package com.mini.librarymanager.controller.member;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.HttpSession;

@Controller
public class MemberController {

    @GetMapping("/logout")
    public String member_logout(final HttpSession httpSession) {

        if(httpSession.getAttribute("loginMemberName")!= null) httpSession.removeAttribute("loginMemberName");
        httpSession.invalidate();

        return "rediect:/index";
        }

    }


