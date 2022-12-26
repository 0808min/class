package com.todo.todospring.mapper;

import com.todo.todospring.domain.TodoDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.sql.Connection;
import java.util.List;

@Mapper
public interface TodoMapper {

    // Todo 전체 리스트
    @Select("Select * from tbl_todo")
    List<TodoDTO> selectAll();

    // tno 값으로 하나의 Todo 정보를 가져오는 메소드
    @Select("Select * from tbl_todo where tno=#{tno}")
    TodoDTO selectByTno(long tno);

    // Todo 정보 입력
    int insertToDo(TodoDTO dto);

    // Todo 정보 수정
    int updateTodo(TodoDTO dto);

    // Todo 정보 삭제
    @Delete("delete from tbl_todo where tno=#{tno}")
    int deleteTodo(long dto);



}
