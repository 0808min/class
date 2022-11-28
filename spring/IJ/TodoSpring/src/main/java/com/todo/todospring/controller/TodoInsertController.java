package com.todo.todospring.controller;

import com.todo.todospring.domain.TodoDTO;
import com.todo.todospring.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDate;

@Log4j2
@Controller
@RequestMapping("/todo/register")
public class TodoInsertController {

    private final TodoService todoService;

    public TodoInsertController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String getInsertForm() {
        return "/todo/register";
    }

    @PostMapping
    public String insert(
           @Valid TodoDTO todoDTO,
           BindingResult bindingResult
    ) {


        if(bindingResult.hasErrors()) {

            log.info(bindingResult.getAllErrors());

            return "redirect:/todo/register";
        }

        log.info(todoDTO.getTodo());
        log.info(todoDTO.getDueDate());
        log.info(todoDTO);


        // 사용자가 입력한 데이터를 받아와야한다
        log.info("todoDTO => " + todoDTO);

        todoService.insertTodo(todoDTO);

        return "redirect:/todo/list";
    }


}
