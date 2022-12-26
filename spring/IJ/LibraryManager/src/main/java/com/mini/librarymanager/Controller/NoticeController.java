package com.mini.librarymanager.Controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.mini.librarymanager.DAO.*;
import com.mini.librarymanager.DTO.*;
import com.mini.librarymanager.Service.*;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {
	@Autowired
	NoticeService noticeService;
	@Autowired
	NoticeDAO noticeDAO;

	// 자유게시판 전체 검색
	@RequestMapping(value = "/notice_detail", method = RequestMethod.GET)
	public String notice_detail(Model model, @RequestParam int noticeID) {
		NoticeDTO noticeDTO = noticeDAO.selectByID(noticeID); 
		
		model.addAttribute("noticeDTO", noticeDTO);

		return "notice_detail";
	}


	// 자유게시판 전체 검색
	@RequestMapping(value = "/unified_search", method = RequestMethod.GET)
	public String notice_unified_search(Model model) {
		List<NoticeDTO> noticeList = noticeDAO.showAll();

		model.addAttribute("noticeList", noticeList);

		return "notice_unified_search";
	}
}
