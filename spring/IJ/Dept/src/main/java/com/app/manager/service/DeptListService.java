package com.app.manager.service;

import com.app.manager.domain.DeptDTO;
import com.app.manager.domain.DeptSearchOption;
import com.app.manager.mapper.DeptMapper;
import com.app.manager.mapper.DeptMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptListService {


    @Autowired(required = false)
    private  DeptMapper deptMapper;

    @Autowired(required = false)
    private DeptMapper2 deptMapper2;

    public  List<DeptDTO> getList() {
        return deptMapper2.selectAll();

    }

    public List<DeptDTO> getSearchList(DeptSearchOption deptSearchOption) {
        return deptMapper.selectByOption(deptSearchOption);
    }
}
