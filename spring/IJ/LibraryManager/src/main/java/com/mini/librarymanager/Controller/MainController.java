package com.mini.librarymanager.Controller;

import javax.servlet.http.*;
import java.util.*;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

import com.mini.librarymanager.DAO.*;
import com.mini.librarymanager.DTO.*;
import com.mini.librarymanager.Service.*;

@Controller
public class MainController {
	@Autowired
	BookService bookService;
	@Autowired
	BookDAO bookDAO;

	@Autowired
	BoardService boardService;
	@Autowired
	BoardDAO boardDAO;

	@Autowired
	NoticeService noticeService;
	@Autowired
	NoticeDAO noticeDAO;

	@Autowired
	GoodService goodService;
	@Autowired
	GoodDAO goodDAO;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		List<NoticeDTO> noticeList = noticeDAO.showFive();
		List<BoardDTO> boardList = boardDAO.showThree();
		List<BookDTO> bookList = bookDAO.showFive();
		List<GoodDTO> goodList = goodDAO.showThree();
		List<BookDTO> hitBookList = bookDAO.hitBookThree();

		model.addAttribute("noticeList", noticeList);
		model.addAttribute("boardList", boardList);
		model.addAttribute("bookList", bookList);
		model.addAttribute("goodList", goodList);
		model.addAttribute("hitBookList", hitBookList);

		return "index";
	}

	// 관리자 페이지 테스트용
	@GetMapping("/admin_index")
	public String admin_index() {
		return "admin_index";
	}
	
	@GetMapping("/logout")
	public String member_logout(final HttpSession session) {
		if (session.getAttribute("loginMemberName") != null)
			session.removeAttribute("loginMemberName");

		session.invalidate();

		return "redirect:/";
	}

	// 회원 페이지 테스트용
	@RequestMapping(value = "/member_index", method = RequestMethod.GET)
	public String member_index(Model model) {
		List<NoticeDTO> noticeList = noticeDAO.showFive();
		List<BoardDTO> boardList = boardDAO.showThree();
		List<BookDTO> bookList = bookDAO.showFive();
		List<GoodDTO> goodList = goodDAO.showThree();
		List<BookDTO> hitBookList = bookDAO.hitBookThree();

		model.addAttribute("noticeList", noticeList);
		model.addAttribute("boardList", boardList);
		model.addAttribute("bookList", bookList);
		model.addAttribute("goodList", goodList);
		model.addAttribute("hitBookList", hitBookList);

		return "member_index";
	}

	// 도서관 소개 페이지
	@GetMapping("/library_introduce")
	public String library_introduce() {
		return "library_introduce";
	}

}