package com.mini.librarymanager.Controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.*;

import com.mini.librarymanager.DAO.*;
import com.mini.librarymanager.DTO.*;
import com.mini.librarymanager.Service.*;
import com.mini.librarymanager.Exception.*;

@Controller
@RequestMapping(value = "/book/*")
public class BookController {
	@Autowired
	BookService bookService;
	@Autowired
	BookDAO bookDAO;

	@Autowired
	MemberService memberService;
	@Autowired
	MemberDAO memberDAO;

	@Autowired
	CheckOutDAO checkOutDAO;

	// 도서 상세 페이지 이동
	@RequestMapping(value = "/book_detail", method = RequestMethod.GET)
	public String book_detail(Model model, @RequestParam String bookISBN, @RequestParam String bookGenre) {
		BookDTO bookDTO = bookDAO.selectByISBN(bookISBN);
		List<BookDTO> genreBookList = bookDAO.genreBook(bookISBN, bookGenre);

		model.addAttribute("bookDTO", bookDTO);
		model.addAttribute("genreBookList", genreBookList);

		return "book_detail";
	}

	// 도서 대여
	@PostMapping("/book_detail")
	public void book_detail(HttpSession session, @RequestParam String bookISBN, HttpServletResponse response)
			throws Exception {
		try {
			MemberDTO sessionMemberDTO = (MemberDTO) session.getAttribute("loginMemberDTO");
			System.out.println(sessionMemberDTO);
			BookDTO bookDTO = bookDAO.selectByISBN(bookISBN);

			CheckOutDTO checkOutDTO = checkOutDAO.getOneCheckOut(sessionMemberDTO.getMemberEmail(), bookISBN);

			if (checkOutDTO != null) // 이미 대여한 도서이면
				throw new NotAvailableException("대여할 수 없습니다.");
			else {
				if (sessionMemberDTO.getMemberRank() == -1)
					throw new BlackListException("대여하지 못하는 등급입니다.");
				else {
					if (sessionMemberDTO.getMemberReturnAvailable() > 0 && bookDTO.getBookCount() > 0) {
						checkOutDAO.insertCheckOut(sessionMemberDTO.getMemberEmail(), bookDTO); // 대여 처리

						bookDTO.setBookCount(bookDTO.getBookCount() - 1); // 재고 수 - 1
						bookDTO.setBookHit(bookDTO.getBookHit() + 1); // 대여 횟수 + 1

						// 대여 가능 수 -1
						sessionMemberDTO.setMemberReturnAvailable(sessionMemberDTO.getMemberReturnAvailable() - 1);
						memberDAO.updateMemberReturnAvailable(sessionMemberDTO);

						bookDAO.updateBook(bookDTO); // 도서 정보 업데이트

						session.setAttribute("loginMemberDTO", sessionMemberDTO);
						response.sendRedirect(
								"/book/book_detail?bookISBN=" + bookISBN + "&bookGenre=" + bookDTO.getBookGenre());
					} else
						throw new NotAvailableException("대여할 수 없습니다.");
				}
			}
		} catch (BlackListException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('대여하지 못하는 등급입니다.'); location.href='/member/my_page';</script>");

			out.flush();
		} catch (NotAvailableException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('대여할 수 없습니다.'); location.href='/member/my_page';</script>");

			out.flush();
		}
	}

	// 도서 전체 검색
	@RequestMapping(value = "/unified_search", method = RequestMethod.GET)
	public String book_unified_search(Model model) {
		List<BookDTO> bookList = bookDAO.showAll();

		model.addAttribute("bookList", bookList);

		return "book_unified_search";
	}

	// 인기 도서 목록
	@RequestMapping(value = "/hit_unified_search", method = RequestMethod.GET)
	public String hit_book_unified_search(Model model) {
		List<BookDTO> hitBookList = bookDAO.hitBook();

		model.addAttribute("hitBookList", hitBookList);

		return "hit_book_unified_search";
	}

	// 인기 도서 목록
	@RequestMapping(value = "/new_unified_search", method = RequestMethod.GET)
	public String new_book_unified_search(Model model) {
		List<BookDTO> newBookList = bookDAO.newBook();

		model.addAttribute("newBookList", newBookList);

		return "new_book_unified_search";
	}
}