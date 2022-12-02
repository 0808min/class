package com.mini.librarymanager.Controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.mini.librarymanager.DAO.*;
import com.mini.librarymanager.DTO.*;
import com.mini.librarymanager.Service.*;
import com.mini.librarymanager.Exception.*;

@Controller

@RequestMapping(value = "/admin/alarm/board/*")
public class AdminBoardController {
	// 관리자 페이지 중
	// 알림 부분 중
	// 자유게시판 부분

	@Autowired
	BoardService boardService;
	@Autowired
	BoardDAO boardDAO;
	/*
	 * @Autowired GoodDAO goodDAO;
	 * 
	 * @Autowired BookDAO bookDAO;
	 */

	// 게시판 비공개
	@RequestMapping(value = "/board_update", method = RequestMethod.GET)
	public String admin_alarm_board_update(Model model) {
		List<BoardDTO> boardList = boardDAO.showAll();

		model.addAttribute("boardList", boardList);

		return "admin_alarm_board_update";
	}

	@PostMapping(value = "/board_update")
	public void admin_alarm_board_update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			int inputBoardID = Integer.parseInt(request.getParameter("inputBoardID"));
			String inputBoardPublic = request.getParameter("inputBoardPublic");

			BoardDTO boardDTO = boardDAO.selectByFBID(inputBoardID);

			if (boardDTO == null) // 게시글이 없을 때
				throw new NotExistingException("존재하지 않는 게시글입니다.");
			else {
				boardDAO.updatePublic(boardDTO, inputBoardPublic);

				response.sendRedirect("/admin/alarm/board/board_update");
			}
		} catch (NotExistingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('존재하지 않는 게시글입니다.'); location.href='/admin/alarm/board/board_update';</script>");

			out.flush();
		}
	}

	// @Autowired
//	BoardService boardService;
	// @Autowired
	// BoardDAO boardDAO;

	// 자유게시판 목록 페이지 이동

	// 자유게시판 세부 페이지 이동

}
