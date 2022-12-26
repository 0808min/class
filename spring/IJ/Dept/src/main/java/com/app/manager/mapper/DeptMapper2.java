package com.app.manager.mapper;

import com.app.manager.domain.DeptDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper2 {

    // 전체부서 리스트
    @Select("select * from dept")
    List<DeptDTO> selectAll();

    // 수정 or 상세 페이지
    @Select("select * from dept where deptno=#{deptno}")
    DeptDTO selectByDeptno(int deptno);

    // 수정(변경) 처리
    @Update("update dept set dname=#{dname}, loc=#{loc} where deptno=#{deptno}")
    int updateDept(DeptDTO deptDTO);

    // 삭제
    @Delete("delete from dept where deptno=#{no}")
    int deleteByDeptno(int deptno);

    // 부서정보 입력
    @Insert("insert into dept values (#{deptno}, #{dname}, #{loc})")
    int insertDept(DeptDTO deptDTO);
}
