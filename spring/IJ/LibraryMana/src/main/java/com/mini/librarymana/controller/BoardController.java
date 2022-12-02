package com.mini.librarymana.controller;

import com.mini.librarymana.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/list")
public class BoardController {

    @Autowired(required = false)
    private BoardService boardService;

    @RequestMapping
    public String getBoardList(Model model) {

        model.addAttribute("boardList", boardService.getTodoList());

        return "board/list";

    }

}
