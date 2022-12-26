package com.app.board.controller.board;

<<<<<<< HEAD
import com.app.board.service.board.BoardListService;
=======
import com.app.board.service.BoardListService;
>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardListController {

    @Autowired
    private BoardListService boardListService;

<<<<<<< HEAD
    @GetMapping("/board/list")   // /board/list
=======
    @GetMapping("/board/list")
>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
    public void getList(
            @RequestParam(value = "p", defaultValue = "1") int pageNum,
            Model model
    ){
<<<<<<< HEAD
        model.addAttribute("boardList", boardListService.getList(pageNum));
        model.addAttribute("listPage", boardListService.getPage(pageNum));
    }
=======

        model.addAttribute("boardList", boardListService.getList(pageNum));
        model.addAttribute("listPage", boardListService.getPage(pageNum));

    }

>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
}
