package com.app.manager.controller.rest;


import com.app.manager.domain.DeptDTO;
import com.app.manager.service.*;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Delete;
import org.springframework.asm.SpringAsmInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequestMapping("/api/v1/depts")
public class DeptRestController {

    // get => 전체 리스트
    // get /{no} => 부서 하나의 정보
    // post => JSON 형식의 데이터를 받아서 입력처리
    // put /{no} => 하나의 부서정보를 수정, 모든 데이터 수정
    // delete /{no} => 부서 정보 하나를 삭제

    @Autowired
    private DeptListService deptListService;

    @Autowired
    private DeptReadService deptReadService;

    @Autowired
    private DeptRegService deptRegService;

    @Autowired
    private DeptEditService deptEditService;

    @Autowired
    private DeptDeleteService deptDeleteService;

    @GetMapping
    public List<DeptDTO> getDeptList() {
        return deptListService.getList();
    }

    @GetMapping("/{no}") // /api/v1/depts/10
    public DeptDTO getDept(
            @PathVariable("no") int deptno
    ) {

        log.info("deptno >>>>>>>> " + deptno);
        return deptReadService.getDept(deptno);
    }

    @PostMapping           // JSON 데이터를 받아서 치리
    public ResponseEntity<String> regDept(
            @RequestBody DeptDTO deptDTO
    ) {
        // ResponseEntity<String> => 응답 데이터를 제네릭으로 정의
        // 객체 생성시 -> 응답 데이터 정의, http header, http status code



        log.info(deptDTO);

        deptRegService.insertDept(deptDTO);

        // header 정의
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("some-header", "soem-value");

//        return new ResponseEntity<>("insert OK", HttpStatus.OK);
        return new ResponseEntity<>("insert OK", httpHeaders, HttpStatus.OK);

    }

    @PutMapping("/{no}")
    public HttpEntity<String> editDept(
            @PathVariable("no") int deptno,
            @RequestBody DeptDTO deptDTO
    ){
        log.info("deptno >>>>>>>>> " + deptno);
        log.info(deptDTO);

        // header 정의
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("some-header", "soem-value");

        deptEditService.editDept(deptDTO);

        return new HttpEntity<String>("update", httpHeaders);
    }

    @DeleteMapping("/{no}")
    public ResponseEntity<String> deleteDept(
            @PathVariable("no") int deptno
    ) {
        log.info("delete >>>>> " + deptno);

        deptDeleteService.deleteDept(deptno);

        return new ResponseEntity<String>("delete", HttpStatus.OK);

    }

}
