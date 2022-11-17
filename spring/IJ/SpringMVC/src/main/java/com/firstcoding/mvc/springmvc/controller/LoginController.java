package com.firstcoding.mvc.springmvc.controller;

import com.firstcoding.mvc.springmvc.domain.LoginRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("/login")
@Log4j2
public class LoginController {

//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String getLoginForm(Model model) {
        model.addAttribute("msg", "아이디와 패스워드를 반드시 입력");
        return "login/form"; // /WEB-INF/views/login/form.jsp
    }

//    @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public String login(String uid, String pw, String p,
//  @RequestParam(value = "p", required = true) String page
    @RequestParam(value = "p", defaultValue = "1") String page,
    HttpServletRequest request, HttpServletResponse response,
    @ModelAttribute("req") LoginRequest loginrequest,
    @RequestParam Map paramMap) {

        String uid2 = request.getParameter("uid");
        String pw2 = request.getParameter("pw2");

        log.info("uid => " + uid);
        log.info("pw => " + pw);
        log.info("p => " + p);
        log.info("p => " + page);
        log.info("uid2 => " + uid2);
        log.info("pw2 => " + pw2);
        log.info("loginrequest => " + loginrequest);
        log.info("paramMap" + paramMap);

        return "login/login"; // "redirect:/index"
    }

    @GetMapping("/info")
    public String info() {
        return "login/info";
    }

}
