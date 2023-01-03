package com.app.board.controller.board;

import com.app.board.domain.BoardWriteRequest;
import com.app.board.security.CustomUser;
import com.app.board.service.board.BoardWriteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

@Controller
@RequestMapping("/board/write")
@Log4j2
public class BoardWriteController {

    @Autowired
    private BoardWriteService boardWriteService;

    @GetMapping
    public void writeForm(
            @AuthenticationPrincipal CustomUser customUser,
            Model model
            ){
        // CustomUser => 현재 로그인 한 사용자의 정보를 가지고 있는 객체
        // CustomUser.boardMember
        model.addAttribute("midx", customUser.getBoardMember().getIdx());

    }

    @PostMapping
    public String write(
            BoardWriteRequest boardWriteRequest
    ){

        log.info(">>>>>>>>>>>>>>>>> " + boardWriteRequest);

        String absolutePath = new File("").getAbsolutePath();
        log.info(">>> path : " + absolutePath);

        boardWriteService.write(boardWriteRequest);


        return "redirect:/board/list";
    }

}
