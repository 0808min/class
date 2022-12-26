package com.mini.librarymana.mapper;


import com.mini.librarymana.domain.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Select("select * from project_board")
    List<BoardDTO> showAll();


}
