package com.todo.todospring.controller;

import com.todo.todospring.domain.TodoDTO;
import com.todo.todospring.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Log4j2
@Controller
@RequestMapping("/todo/modify")
public class TodoModifyController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public String getModifyForm(
            Model model,
            @RequestParam("tno") int tno){

        model.addAttribute("todo", todoService.getTodo(tno));

        return "todo/modify";
    }

    @PostMapping
    public String modify(
            @RequestParam("tno") int tno,
            @RequestParam("todo") String todo,
            @RequestParam("dueDate") String dueDate,
            String finished
    ){

        TodoDTO todoDTO = new TodoDTO(tno, todo, LocalDate.parse(dueDate), finished == null ? false : true);
        log.info(todoDTO);

        todoService.modify(todoDTO);


        return "redirect:/todo/list";
    }


}
