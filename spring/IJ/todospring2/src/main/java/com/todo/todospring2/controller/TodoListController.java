package com.todo.todospring2.controller;

import com.todo.todospring2.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoListController {

//    @Autowired
    private final TodoService todoService;

    public TodoListController(TodoService todoService) {
        this.todoService = todoService;
    }


//    public TodoListController(TodoServiceOld todoService) {
//        this.todoService = todoService;
//    }

    @RequestMapping("/todo/list")
    public String getTodolist(Model model) {

        model.addAttribute("todoList",todoService.getTodoList());


        return "todo/list";
    }

}
