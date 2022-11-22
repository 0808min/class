package com.todo.todofinal.controller;

import com.todo.todofinal.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoReadController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/todo/read")
    public void readTodo(Model model, @RequestParam("tno") int tno){

        model.addAttribute("todo", todoService.getTodo(tno));

        //return "todo/read";

    }

}
