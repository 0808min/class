package com.todo.todospring.controller;

import com.todo.todospring.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TodoReadController {

    private final TodoService todoService;

    public TodoReadController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todo/read")
    public void readTodo(Model model, @RequestParam("tno") int tno) {

        todoService.getTodo(tno);

        model.addAttribute("todo", null);

//        return "todo/read";

    }

}
