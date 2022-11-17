package com.firstcoding.mvc.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class sampleController {

    @RequestMapping("/sample")
    public ModelAndView getSamplePage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("sample"); // => /WEB-INF/views/sample.jsp

        return mav;
    }

    @RequestMapping("/sample2")
    public String getStringPage() {
        return "sample2";  // /WEB-INF/views/sample2.jsp
    }

    @RequestMapping("/sample3")
    public void getVoidPage() {
    }

}
