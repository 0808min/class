package com.app.board.controller.board;

<<<<<<< HEAD
import com.app.board.service.board.BoardDeleteService;
=======
import com.app.board.service.BoardDeleteService;
>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardDeleteController {

    @Autowired
    private BoardDeleteService boardDeleteService;

    @GetMapping("/board/delete")
<<<<<<< HEAD
    public String delete(
            @RequestParam("bno") int bno
    ){
=======
    private String delete(
            @RequestParam("bno") int bno
    ) {
>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135

        boardDeleteService.delete(bno);

        return "redirect:/board/list";
<<<<<<< HEAD
    }
=======

    }

>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
}
