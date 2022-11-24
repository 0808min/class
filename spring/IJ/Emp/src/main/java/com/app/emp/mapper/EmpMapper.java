package com.app.emp.mapper;

import com.app.emp.domain.EmpDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper {

    List<EmpDTO> selectAll();

    int insertEmp(EmpDTO empDTO);

}
