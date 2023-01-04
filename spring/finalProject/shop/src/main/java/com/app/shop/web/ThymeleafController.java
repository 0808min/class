package com.app.shop.web;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/thymeleaf")
@Controller
public class ThymeleafController {
    @GetMapping(value = "/ex")
    public String thymeleafExample() {
        return "thymeleafEx";
    }
}
