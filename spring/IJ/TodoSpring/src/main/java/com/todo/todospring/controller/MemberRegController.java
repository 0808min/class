package com.todo.todospring.controller;

import com.todo.todospring.domain.MemberRegRequest;
import com.todo.todospring.service.MemberRegService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@Controller
@RequestMapping("/member/register")
public class MemberRegController {


    private MemberRegService regService;

    public MemberRegController(MemberRegService regService) {
        this.regService = regService;
    }

    @GetMapping
    public String getRegForm() {
        return "member/regForm";
    }

    @PostMapping
    public String reg(
            MemberRegRequest regRequest,
            HttpServletRequest request
    ) throws Exception {

        log.info(regRequest);
        regService.memberReg(regRequest, request);


        //log.info(regRequest.toMember());

        return "redirect:/index.jsp";
    }
}
