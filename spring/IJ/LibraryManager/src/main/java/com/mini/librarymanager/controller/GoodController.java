package com.mini.librarymanager.Controller;

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
@RequestMapping(value = "/good/**")
public class GoodController {
	// 관리자 페이지 중
	// 알림 부분 중
	// 사서 추천 도서 부분
	
	@Autowired
	GoodService goodService;
	@Autowired
	GoodDAO goodDAO;

	@Autowired
	BookDAO bookDAO;


	
	// 자유게시판 전체 검색
	@RequestMapping(value = "/unified_search", method = RequestMethod.GET)
	public String good_unified_search(Model model) {
		List<GoodDTO> goodList = goodDAO.showAll();

		model.addAttribute("goodList", goodList);

		return "good_unified_search";
	}	

	@RequestMapping(value = "/good_detail", method = RequestMethod.GET)
	public String good_detail(Model model, @RequestParam int goodID) {
		GoodDTO goodDTO = goodDAO.showDetail(goodID);

		model.addAttribute("goodDTO", goodDTO);

		return "good_detail";
	}
	
}