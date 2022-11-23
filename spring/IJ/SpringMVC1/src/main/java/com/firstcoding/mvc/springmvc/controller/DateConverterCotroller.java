package com.firstcoding.mvc.springmvc.controller;

import com.firstcoding.mvc.springmvc.domain.UserRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Method;
import java.time.LocalDate;

@Controller
@RequestMapping("/date")
@Log4j2
public class DateConverterCotroller {

    //@GetMapping
    @RequestMapping( method = RequestMethod.GET )
    public String getDateForm(){
        return "dateForm";
    }

    @PostMapping
    public String date(
            LocalDate date,
            UserRequest userRequest,
            Model model
    ){
        model.addAttribute("date", date);
        return "date";
    }


}
