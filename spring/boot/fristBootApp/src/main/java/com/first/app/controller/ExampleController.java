package com.first.app.controller;

import com.first.app.domain.DeptDTO;
import com.first.app.service.DeptListService;
import com.first.app.service.DeptReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ex")
public class ExampleController {

    @Autowired
    private DeptReadService deptReadService;

    @Autowired
    private DeptListService deptListService;


    @GetMapping("/ex1")
    public String ex1(Model model, HttpSession httpSession) {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        model.addAttribute("list", list);

        model.addAttribute("dept", deptReadService.getDept(20));

        model.addAttribute("deptlist", deptListService.getList());

        Map<String, DeptDTO> map = new HashMap<>();
        map.put("10", deptReadService.getDept(10));
        map.put("20", deptReadService.getDept(20));

        model.addAttribute("deptmap", map);

        httpSession.setAttribute("loginData", "COOL");

        model.addAttribute("localDataTime", LocalDateTime.now());

        model.addAttribute("data", "DATA123");
        model.addAttribute("nullData", null);

        return "ex/ex1";  // ex/ex1.html
    }

}
