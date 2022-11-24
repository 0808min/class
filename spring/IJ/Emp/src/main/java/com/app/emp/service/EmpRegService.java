package com.app.emp.service;


import com.app.emp.domain.EmpDTO;
import com.app.emp.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpRegService {

    @Autowired(required = false)
    private EmpMapper empMapper;

    public int insertEmp(EmpDTO empDTO){
        return empMapper.insertEmp(empDTO);
    }
}
