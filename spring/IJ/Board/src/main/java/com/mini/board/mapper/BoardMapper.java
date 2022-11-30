package com.mini.board.mapper;

import com.mini.board.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<Board> selectAll();

}
