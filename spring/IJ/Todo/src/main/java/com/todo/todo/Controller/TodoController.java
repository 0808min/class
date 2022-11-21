package com.todo.todo.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("todo")
@Log4j2
public class TodoController {

    @GetMapping
    public String getList() {
        return "/todo/list";
    }

    @GetMapping("register")
    public String getRegister() { return  "/todo/register"; }






}
