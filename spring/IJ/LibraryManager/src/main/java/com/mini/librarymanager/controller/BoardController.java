package com.mini.librarymanager.Controller;

import com.mini.librarymanager.Exception.NotAvailableException;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mini.librarymanager.DAO.*;
import com.mini.librarymanager.DTO.*;
import com.mini.librarymanager.Service.*;


@Controller
@RequestMapping(value = "/board/*")
public class BoardController {
	@Autowired
	BoardService boardService;
	@Autowired
	BoardDAO boardDAO;

	@Autowired
	CommentDAO commentDAO;

	// 자유게시판 세부 페이지
	@RequestMapping(value = "/board_detail", method = RequestMethod.GET)
	public String board_detail(Model model, @RequestParam int boardID) {
		BoardDTO boardDTO = boardDAO.selectByFBID(boardID);
		List<CommentDTO> commentDTOList = commentDAO.selectByFBID(boardID);

		model.addAttribute("commentDTOList", commentDTOList);
		model.addAttribute("boardDTO", boardDTO);

		return "board_detail";
	}

	// 자유게시판 세부 페이지 댓글
	@PostMapping(value = "/board_detail")
	public void upload_comment(HttpServletRequest request, @RequestParam int boardID, HttpSession session,
			HttpServletResponse response) throws Exception {
		BoardDTO boardDTO = boardDAO.selectByFBID(boardID);

		String inputCommentContent = request.getParameter("inputCommentContent");

		int latestCommentID = boardService.findLatestCID(boardID);

		CommentDTO commentDTO = new CommentDTO(latestCommentID + 1, boardDTO.getBoardID(),
				(String) session.getAttribute("loginMemberName"), inputCommentContent);

		commentDAO.insertComment(commentDTO);

		response.sendRedirect("/board/board_detail?boardID=" + boardID);
	}

	// 자유게시판 전체 검색
	@RequestMapping(value = "/unified_search", method = RequestMethod.GET)
	public String board_unified_search(Model model) {
		List<BoardDTO> boardList = boardDAO.showVisibleBoard();

		model.addAttribute("boardList", boardList);

		return "board_unified_search";
	}

	// 게시판 글쓰기
	@GetMapping("/board_write")
	public String board_write() {
		return "board_write";
	}

	// 게시판 굴 작성 처리
	@RequestMapping("/board_write")
	public void board_write(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {
		String inputBoardTitle = request.getParameter("inputBoardTitle");
		String inputBoardContent = request.getParameter("inputBoardContent").replaceAll("\r\n", "<br />");

		MemberDTO memberDTO = (MemberDTO) session.getAttribute("loginMemberDTO");

		BoardDTO boardDTO = new BoardDTO(memberDTO.getMemberEmail(), inputBoardTitle, inputBoardContent);

		boardDAO.insertBoard(memberDTO.getMemberEmail(), boardDTO);

		response.sendRedirect("/board/unified_search");
	}

	// 게시판 삭제
	@RequestMapping("/board_delete")
	public void board_delete(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@RequestParam int boardID) throws Exception {
		try {
			BoardDTO boardDTO = boardDAO.selectByFBID(boardID);

			MemberDTO memberDTO = (MemberDTO) session.getAttribute("loginMemberDTO");

			
			if (memberDTO == null)
				throw new NotAvailableException("삭제할 수 없습니다.");

			if (!boardDTO.getBoardEmail().equals(memberDTO.getMemberEmail()))
				throw new NotAvailableException("삭제할 수 없습니다.");

			boardDAO.deleteBoard(boardID);

			response.sendRedirect("/board/unified_search");
		} catch (NotAvailableException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('삭제할 수 없습니다.'); location.href='/board/board_detail?boardID=" + boardID
					+ "';</script>");

			out.flush();
		}
	}
}
