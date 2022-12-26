package com.app.emp.service;


import com.app.emp.domain.EmpDTO;
import com.app.emp.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpListService {

    @Autowired(required = false)
    private EmpMapper empMapper;

    public List<EmpDTO> getlist() {
        return empMapper.selectAll();
    }

}
