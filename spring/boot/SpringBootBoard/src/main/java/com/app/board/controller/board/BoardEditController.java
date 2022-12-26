package com.app.board.controller.board;

import com.app.board.domain.BoardEditRequest;
<<<<<<< HEAD
import com.app.board.service.board.BoardEditService;
import com.app.board.service.board.BoardViewService;
=======
import com.app.board.service.BoardDeleteService;
import com.app.board.service.BoardEditService;
import com.app.board.service.BoardViewService;
>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board/edit")
@Log4j2
public class BoardEditController {

    @Autowired
    private BoardViewService boardViewService;

    @Autowired
    private BoardEditService boardEditService;

    @GetMapping
<<<<<<< HEAD
    public void edtiForm(
            @RequestParam("bno") int bno,
            @RequestParam("p") int p,
            Model model
    ){
        model.addAttribute("board", boardViewService.selectBoardDTO(bno));
        model.addAttribute("curPageNum", p);
    }

=======
    public void editForm(
            @RequestParam("bno") int bno,
            @RequestParam("p") int p,
            Model model
    ) {

        model.addAttribute("board", boardViewService.selectBoardDTO(bno));
        model.addAttribute("currPageNum", p);

    }
>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135

    @PostMapping
    public String edit(
            BoardEditRequest boardEditRequest,
            RedirectAttributes redirectAttributes
<<<<<<< HEAD

    ){
        log.info(boardEditRequest);

        redirectAttributes.addAttribute("bno", boardEditRequest.getBno());
        redirectAttributes.addAttribute("p", boardEditRequest.getCurPageNum());
=======
    ) {

        log.info(boardEditRequest);

        redirectAttributes.addAttribute("bno", boardEditRequest.getBno());
        redirectAttributes.addAttribute("p", boardEditRequest.getCurrPageNum());
>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135

        boardEditService.edit(boardEditRequest);

        return "redirect:/board/view";
<<<<<<< HEAD

    }
=======
    }



>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
}
