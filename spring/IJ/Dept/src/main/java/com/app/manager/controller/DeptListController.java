package com.app.manager.controller;

import com.app.manager.domain.DeptSearchOption;
import com.app.manager.service.DeptListService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
public class DeptListController {

    @Autowired
    private DeptListService deptlistService;

    @RequestMapping("/dept/list")
    public String getDeptList(
            DeptSearchOption deptSearchOption,
            Model model
    ) {
        log.info("dept list ...");
        model.addAttribute("deptlist", deptlistService.getSearchList(deptSearchOption));

        return "dept/list";
    }

}
