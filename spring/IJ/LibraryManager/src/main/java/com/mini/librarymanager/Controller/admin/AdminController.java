package com.mini.librarymanager.Controller.admin;

import java.io.PrintWriter;
import java.sql.Blob;

import javax.servlet.http.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.mini.librarymanager.Service.*;
import com.mini.librarymanager.DTO.*;
import com.mini.librarymanager.Exception.*;
import com.mini.librarymanager.DAO.*;

@Controller
@RequestMapping(value = "/admin/*")
public class AdminController {
	// 관리자 로그아웃
	@GetMapping("/logout")
	public String member_logout(final HttpSession session) {
		if (session.getAttribute("loginMemberName") != null)
			session.removeAttribute("loginMemberName");

		session.invalidate();

		return "redirect:/";
	}
}
