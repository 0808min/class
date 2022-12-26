package com.app.manager.controller.rest;

import com.app.manager.domain.DeptDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Future;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
@Log4j2
public class ExampleRestController {

    // 메소드의 반환타입이 String -> 문자열 출력

    @GetMapping("/sample1")
    public String sayHello() {
        return "Hello";
    }

    // 객체의 반환은 JSON 형식으로 응답된다
    @GetMapping("/sample2")
    public DeptDTO getDept() {
        DeptDTO deptDTO = DeptDTO.builder()
                .deptno(90)
                .dname("DEV")
                .loc("SEOUL")
                .build();

        return deptDTO;
    }

    @GetMapping("/sample3")
    public List<DeptDTO> getDeptList() {
        List<DeptDTO> list = new ArrayList<>();
        list.add(new DeptDTO(10, "test10", "LOC10"));
        list.add(new DeptDTO(20, "test20", "LOC20"));
        list.add(new DeptDTO(30, "test30", "LOC30"));

        return list;

    }

    @GetMapping("/sample4")
    public Map<Integer, DeptDTO> getDeptMap() {

        Map<Integer, DeptDTO> map = new HashMap<>();
        map.put(10, new DeptDTO(10, "test10", "LOC10"));
        map.put(20, new DeptDTO(20, "test20", "LOC20"));
        map.put(30, new DeptDTO(30, "test30", "LOC30"));
        map.put(40, new DeptDTO(40, "test40", "LOC40"));

        return map;

    }

}
