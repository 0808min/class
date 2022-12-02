package com.mini.librarymanager.controller.board;

import com.mini.librarymanager.service.BoardService;
import com.mini.librarymanager.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

//    @Autowired(required = false)
//    private BoardService boardService;

    @RequestMapping("/board/list")
    public String getBoardList() {

        return "board/list";

    }

}
