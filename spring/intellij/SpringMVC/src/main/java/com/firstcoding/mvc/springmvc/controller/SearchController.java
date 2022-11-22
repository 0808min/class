package com.firstcoding.mvc.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    @RequestMapping("/search/search")
    public String searchForm(){
        return "searchForm";
    }

    @RequestMapping("/board/board")
    public String board(){
        return "board";     // /WEB-INF/views/board/board .jsp
    }

    @ModelAttribute("keywords")
    public String[] getKeywords(){
        return new String[] {"손흥민", "월드컵", "이강인", "호날두", "독일" };
    }

    @ModelAttribute("searchType")
    public List<String> getSearchType(){

        List<String> list = new ArrayList<>();
        list.add("id");
        list.add("title");
        list.add("keyword");

        return list;
    }


}
