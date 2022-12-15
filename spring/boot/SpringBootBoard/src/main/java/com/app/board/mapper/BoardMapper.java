package com.app.board.mapper;

import com.app.board.domain.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Select("select * from tbl_board")
    List<BoardDTO> selectAll();

    @Select("select * from tbl_board order by bno desc limit #{start},#{count}")
    List<BoardDTO> selectList(@Param("start") int start, @Param("count") int count);




}
