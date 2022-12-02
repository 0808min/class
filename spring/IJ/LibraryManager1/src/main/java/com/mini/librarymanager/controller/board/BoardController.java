package com.mini.librarymanager.controller.board;

import com.mini.librarymanager.service.BoardService;
import com.mini.librarymanager.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/list")
public class BoardController {

//    @Autowired(required = false)
//    private BoardService boardService;

    @GetMapping("list")
    public String getBoardList() {

        return "/index";

    }

}
