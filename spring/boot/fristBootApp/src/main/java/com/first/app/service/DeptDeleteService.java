package com.first.app.service;

import com.first.app.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class DeptDeleteService {

    @Autowired(required = false)
    private DeptMapper deptMapper;

    public int deleteDept(int deptno) {
        return deptMapper.deleteByDeptno(deptno);
    }

}
