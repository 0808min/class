package com.todo.todospring.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller

public class LogoutController {

    @GetMapping("/logout")
    public String logout(
            HttpSession httpSession
    ) {
        httpSession.invalidate();

        return "redirect:/index.jsp";
    }

}
