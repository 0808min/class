package com.app.shop.web;

import com.app.shop.entity.item.Item;
import com.querydsl.core.types.Predicate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/thymeleaf")
@Controller
public class ThymeleafController {
    @GetMapping(value = "/ex")
    public String thymeleafExample() {
        return "thymeleaf";
    }
}






