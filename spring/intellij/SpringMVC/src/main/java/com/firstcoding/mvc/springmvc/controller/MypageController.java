package com.firstcoding.mvc.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class MypageController {

    @GetMapping("/mypage1")
    public String getMypage1(){
        return "mypage/mypage1";
    }

    @GetMapping("/mypage2")
    public String getMypage2(){
        return "mypage/mypage2";
    }

    @GetMapping("/mypage3")
    public String getMypage3(){
        return "mypage/mypage3";
    }
}
