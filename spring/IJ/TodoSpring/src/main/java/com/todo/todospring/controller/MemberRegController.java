package com.todo.todospring.controller;

import com.todo.todospring.domain.MemberRegRequest;
import com.todo.todospring.service.MemberRegService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
           @Valid MemberRegRequest regRequest,
            BindingResult bindingResult,
            HttpServletRequest request
    ) throws Exception {

        if(bindingResult.hasErrors()) {
            log.info(bindingResult.getAllErrors());

            return "redirect:/member/register";
        }

        log.info(regRequest);
        regService.memberReg(regRequest, request);


        //log.info(regRequest.toMember());

        return "redirect:/index.jsp";
    }
}
