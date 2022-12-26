package com.app.emp.controller;

import com.app.emp.domain.EmpDTO;
import com.app.emp.service.EmpRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp/register")
public class EmpRegContorller {

    @Autowired(required = false)
    private EmpRegService empRegService;

    @GetMapping
    public void getRegForm() {
    }

    @PostMapping
    public String reg(
            EmpDTO empDTO
    ) {

        empRegService.insertEmp(empDTO);

        return "redirect:/emp/list";
    }
}
