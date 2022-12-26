package com.app.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
<<<<<<< HEAD
    public String index(){
        return "index";
    }
=======
    public String index() {
        return "index";
    }


>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
}
