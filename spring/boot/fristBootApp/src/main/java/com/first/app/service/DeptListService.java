package com.first.app.service;


import com.first.app.domain.DeptDTO;
import com.first.app.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptListService {


    @Autowired(required = false)
    private DeptMapper deptMapper;


    public  List<DeptDTO> getList() {
        return deptMapper.selectAll();

    }

/*    public List<DeptDTO> getSearchList(DeptSearchOption deptSearchOption) {
        return deptMapper.selectByOption(deptSearchOption);
    }*/
}
