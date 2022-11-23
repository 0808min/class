package com.todo.todofinal.controller;

import com.todo.todofinal.domain.MemberRegRequset;
import com.todo.todofinal.service.MemberRegService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@Controller
@RequestMapping("/member/register")
public class MemberRegController {

    @Autowired
    private MemberRegService regService;

    @GetMapping
   public String regForm() {
       return "/member/regForm";
   }

   @PostMapping
   public String reg(
           MemberRegRequset regRequset,
           HttpServletRequest request

   ) throws Exception {

        log.info(regRequset);
//        log.info(regRequset.toMember());
       regService.memberReg(regRequset, request);
        return "redirect:/index.jsp";
   }

}
