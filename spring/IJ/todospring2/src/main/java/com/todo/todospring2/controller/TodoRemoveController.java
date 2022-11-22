package com.todo.todospring2.controller;

import com.todo.todospring2.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TodoRemoveController {

    private TodoService todoService;

    public TodoRemoveController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/todo/remove")
    public String removeTodo(
            @RequestParam("tno")int tno
    ) {

        todoService.deleteBytno(tno);
        return "redirect:/todo/list";
    }
}
