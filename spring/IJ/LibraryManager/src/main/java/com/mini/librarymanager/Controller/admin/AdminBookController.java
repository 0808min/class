package com.mini.librarymanager.Controller.admin;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.mini.librarymanager.DAO.*;
import com.mini.librarymanager.DTO.*;
import com.mini.librarymanager.Exception.*;
import com.mini.librarymanager.Service.*;

@Controller
@RequestMapping(value = "/admin/book/*")
public class AdminBookController {
	// 관리자 페이지 중
	// 도서 부분

	@Autowired
	BookService bookService;
	@Autowired
	BookDAO bookDAO;

	@Autowired
	CheckOutDAO checkOutDAO;

	// 도서 추가 페이지 이동
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String admin_book_add(Model model) {
		List<BookDTO> bookList = bookDAO.showAll();

		model.addAttribute("bookList", bookList);

		return "admin_book_add";
	}

	// 도서 추가 처리
	@PostMapping(value = "/add")
	public void admin_book_add(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("inputBookImage") MultipartFile _inputBookImage) throws Exception {
		try {
			String inputBookISBN = request.getParameter("inputBookISBN");
			String inputBookGenre = request.getParameter("inputBookGenre");
			String inputBookTitle = request.getParameter("inputBookTitle");
			String inputBookAuthor = request.getParameter("inputBookAuthor");
			String inputBookPublisher = request.getParameter("inputBookPublisher");
			String inputBookCountString = request.getParameter("inputBookCount");
			String inputBookImage = null;
			///
			String inputBookSummary = request.getParameter("inputBookSummary").replaceAll("\r\n", "<br />");
			int inputBookHit = 0;

			int inputBookCount;

			BookDTO bookDTO = bookDAO.selectByISBN(inputBookISBN);

			if (bookDTO != null)
				throw new AlreadyExistingException("이미 존재하는 도서입니다.");

			if (!_inputBookImage.isEmpty()) {
				try {
					String uploadDir = "/bookImageStorage/";
					String realPathUpload = request.getServletContext().getRealPath(uploadDir);

					String fileName = _inputBookImage.getOriginalFilename();
					String filePath = realPathUpload + fileName;

					File files = new File(filePath);
					_inputBookImage.transferTo(files);

					inputBookImage = fileName;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

			if (inputBookISBN.equals("") || inputBookGenre.equals("") || inputBookTitle.equals("")
					|| inputBookAuthor.equals("") || inputBookPublisher.equals(""))
				throw new FillOutInformationException("모든 정보를 입력해주세요.");

			if (inputBookCountString.equals(""))
				inputBookCount = 1;
			else
				inputBookCount = Integer.parseInt(inputBookCountString);

			bookDTO = new BookDTO(inputBookISBN, inputBookTitle, inputBookAuthor, inputBookGenre, inputBookPublisher,
					inputBookImage, inputBookCount, inputBookSummary);

			bookDTO = bookService.addBook(bookDTO);

			System.out.println(bookDTO.toString());

			response.sendRedirect("/admin/book/add");
		} catch (AlreadyExistingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('이미 존재하는 도서입니다.'); location.href='/admin/book/add';</script>");

			out.flush();
		} catch (FillOutInformationException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('모든 정보를 입력해주세요.'); location.href='/admin/book/add';</script>");

			out.flush();
		}
	}

	// 도서 삭제 페이지 이동
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String admin_book_delete(Model model) {
		List<BookDTO> bookList = bookDAO.showAll();

		model.addAttribute("bookList", bookList);

		return "admin_book_delete";
	}

	// 도서 삭제 처리
	@PostMapping(value = "/delete")
	public void admin_book_delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String inputBookISBN = request.getParameter("inputBookISBN");
			String inputBookTitle = request.getParameter("inputBookTitle");
			String inputBookTitleConfirm = request.getParameter("inputBookTitleConfirm");

			BookDTO bookDTO = bookDAO.selectByISBN(inputBookISBN);

			List<CheckOutDTO> checkOutDTO = checkOutDAO.selectByISBN(inputBookISBN);

			if (checkOutDTO == null) // 대여한 사람이 있다는 것
				throw new AlreadyExistingException("해당 도서를 대여한 회원이 있습니다.");

			if (bookDTO == null)
				throw new NotExistingException("존재하지 않는 도서입니다.");
			else {
				if (bookDTO.getBookTitle().equals(inputBookTitle)) {
					if (inputBookTitle.equals(inputBookTitleConfirm)) {
						bookService.deleteBook(bookDTO);

						response.sendRedirect("/admin/book/delete");
					} else
						throw new NotMatchingException("확인 제목과 맞지 않습니다.");
				} else
					throw new NotExistingException("책의 제목이 맞지 않습니다.");
			}
		} catch (NotMatchingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('확인 제목과 맞지 않습니다.'); location.href='/admin/book/delete';</script>");

			out.flush();
		} catch (NotExistingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('존재하지 않는 도서입니다.'); location.href='/admin/book/delete';</script>");

			out.flush();
		} catch (ConfirmNotMatchingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('책의 제목이 맞지 않습니다.'); location.href='/admin/book/delete';</script>");

			out.flush();
		} catch (AlreadyExistingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('해당 도서를 대여한 회원이 있습니다.'); location.href='/admin/book/delete';</script>");

			out.flush();
		}
	}

	// 도서 수정 페이지 이동
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String admin_book_update(Model model) {
		List<BookDTO> bookList = bookDAO.showAll();

		model.addAttribute("bookList", bookList);

		return "admin_book_update";
	}

	// 도서 추가 처리
	@PostMapping(value = "/update")
	public void admin_book_update(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("inputBookImage") MultipartFile _inputBookImage) throws Exception {
		try {
			String inputBookISBN = request.getParameter("inputBookISBN");
			String inputBookGenre = request.getParameter("inputBookGenre");
			String inputBookTitle = request.getParameter("inputBookTitle");
			String inputBookAuthor = request.getParameter("inputBookAuthor");
			String inputBookPublisher = request.getParameter("inputBookPublisher");
			String inputBookCountString = request.getParameter("inputBookCount");
			String inputBookImage = null;
			///
			String inputBookSummary = request.getParameter("inputBookSummary").replaceAll("\r\n", "<br />");
			int inputBookHit = 0;

			int inputBookCount;

			BookDTO bookDTO = bookDAO.selectByISBN(inputBookISBN);

			if (bookDTO == null)
				throw new NotExistingException("수정할 도서가 없습니다.");

			if (!_inputBookImage.isEmpty()) {
				try {
					String uploadDir = "/bookImageStorage/";
					String realPathUpload = request.getServletContext().getRealPath(uploadDir);

					String fileName = _inputBookImage.getOriginalFilename();
					String filePath = realPathUpload + fileName;

					File files = new File(filePath);
					_inputBookImage.transferTo(files);

					inputBookImage = fileName;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

			if (inputBookISBN.equals("") || inputBookGenre.equals("") || inputBookTitle.equals("")
					|| inputBookAuthor.equals("") || inputBookPublisher.equals(""))
				throw new FillOutInformationException("모든 정보를 입력해주세요.");

			if (inputBookCountString.equals(""))
				inputBookCount = 1;
			else
				inputBookCount = Integer.parseInt(inputBookCountString);

			bookDTO = new BookDTO(inputBookISBN, inputBookTitle, inputBookAuthor, inputBookGenre, inputBookPublisher,
					inputBookImage, inputBookCount, inputBookSummary);

			bookDTO = bookService.updateBook(bookDTO);

			System.out.println(bookDTO.toString());

			response.sendRedirect("/admin/book/update");
		} catch (NotExistingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('수정할 도서가 없습니다.'); location.href='/admin/book/update';</script>");

			out.flush();
		} catch (FillOutInformationException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('모든 정보를 입력해주세요.'); location.href='/admin/book/update';</script>");

			out.flush();
		}
	}

	// 연체 도서 페이지 이동
	@RequestMapping(value = "/overdue", method = RequestMethod.GET)
	public String admin_book_overdue(Model model) {
		List<CheckOutDTO> bookOverDueList = checkOutDAO.selectOverDue();

		model.addAttribute("bookOverDueList", bookOverDueList);

		return "admin_book_overdue";
	}
}
