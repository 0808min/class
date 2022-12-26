package com.mini.librarymanager.Controller.admin;

import java.io.*;
import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.mini.librarymanager.DAO.*;
import com.mini.librarymanager.DTO.*;
import com.mini.librarymanager.Service.*;
import com.mini.librarymanager.Exception.*;

@Controller
@RequestMapping(value = "/admin/alarm/notice/*")
public class AdminNoticeController {
	// 관리자 페이지 중
	// 알림 부분 중
	// 공지 사항 부분

	@Autowired
	NoticeService noticeService;
	@Autowired
	NoticeDAO noticeDAO;

	// 공지사항 추가 페이지 이동
	@RequestMapping(value = "/notice_add", method = RequestMethod.GET)
	public String admin_alarm_notice_add(Model model) {
		List<NoticeDTO> noticeList = noticeDAO.showAll();

		model.addAttribute("noticeList", noticeList);

		return "admin_alarm_notice_add";
	}

	// 공지사항 추가 처리
	@PostMapping(value = "/notice_add")
	public void admin_alarm_notice_add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String inputNoticeTitle = request.getParameter("inputNoticeTitle");
			String inputNoticeContent = request.getParameter("inputNoticeContent").replaceAll("\r\n", "<br />");			
			
			NoticeDTO noticeDTO = new NoticeDTO(inputNoticeTitle, inputNoticeContent);

			noticeDTO = noticeService.uploadNotice(noticeDTO);

			if (noticeDTO == null) {
				throw new AlreadyExistingException("이미 존재하는 공지입니다.");
			} else {
				System.out.println(noticeDTO);

				response.sendRedirect("/admin/alarm/notice/notice_add");
			}
		} catch (AlreadyExistingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('이미 존재하는 공지입니다.'); location.href='/admin/alarm/notice/notice_add';</script>");

			out.flush();
		}
	}

	// 공지사항 삭제 페이지 이동
	@RequestMapping(value = "/notice_delete", method = RequestMethod.GET)
	public String admin_alarm_notice_delete(Model model) {
		List<NoticeDTO> noticeList = noticeDAO.showAll();

		model.addAttribute("noticeList", noticeList);

		return "admin_alarm_notice_delete";
	}

	// 공지사항 삭제 처리
	@PostMapping(value = "/notice_delete")
	public void admin_alarm_notice_delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String inputNoticeID = request.getParameter("inputNoticeID");
			String inputNoticeIDConfirm = request.getParameter("inputNoticeIDConfirm");

			NoticeDTO noticeDTO = noticeDAO.selectByID(Integer.parseInt(inputNoticeID));

			if (noticeDTO == null)
				throw new NotExistingException("존재하지 않는 공지입니다.");
			else {
				if (inputNoticeID.equals(inputNoticeIDConfirm)) {
					noticeService.deleteNotice(noticeDTO);

					response.sendRedirect("/admin/alarm/notice/notice_delete");
				} else
					throw new NotMatchingException("확인 아이디가 맞지 않습니다.");
			}
		} catch (NotExistingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('존재하지 않는 공지입니다.'); location.href='/admin/alarm/notice/notice_delete';</script>");

			out.flush();
		} catch (NotMatchingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println(
					"<script>alert('확인 아이디가 맞지 않습니다.'); location.href='/admin/alarm/notice/notice_delete';</script>");

			out.flush();
		}
	}
}
