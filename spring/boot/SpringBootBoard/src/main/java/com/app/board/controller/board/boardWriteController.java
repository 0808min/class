package com.app.board.controller.board;

import com.app.board.domain.BoardWriteRequest;
<<<<<<< HEAD
import com.app.board.security.CustomUser;
import com.app.board.service.board.BoardWriteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
=======
import com.app.board.service.BoardWriteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

@Controller
@RequestMapping("/board/write")
@Log4j2
<<<<<<< HEAD
public class BoardWriteController {
=======
public class boardWriteController {
>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135

    @Autowired
    private BoardWriteService boardWriteService;

    @GetMapping
<<<<<<< HEAD
    public void writeForm(
            @AuthenticationPrincipal CustomUser customUser,
            Model model
            ){
        // CustomUser => 현재 로그인 한 사용자의 정보를 가지고 있는 객체
        // CustomUser.boardMember
        model.addAttribute("midx", customUser.getBoardMember().getIdx());
=======
    public void writeForm() {
>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135

    }

    @PostMapping
    public String write(
            BoardWriteRequest boardWriteRequest
<<<<<<< HEAD
    ){

        log.info(">>>>>>>>>>>>>>>>> " + boardWriteRequest);

        String absolutePath = new File("").getAbsolutePath();
        log.info(">>> path : " + absolutePath);

        boardWriteService.write(boardWriteRequest);


        return "redirect:/board/list";
    }

=======
    ) {
        log.info(">>>>>>>>>>>>>" +boardWriteRequest);

        String absolutePath = new File("").getAbsolutePath();
        log.info(">>>> path" + absolutePath);

        boardWriteService.write(boardWriteRequest);

        return "redirect:/board/list";
    }
>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
}
