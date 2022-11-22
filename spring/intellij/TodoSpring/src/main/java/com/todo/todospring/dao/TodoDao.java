package com.todo.todospring.dao;


import com.todo.todospring.domain.TodoDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface TodoDao {

    // 전체 리스트 출력
    List<TodoDTO> selectAll(Connection conn) throws SQLException;
    
    // 하나의 항목 출력
    TodoDTO selectByTno(Connection conn, long tno) throws SQLException;

    // 할일 등록
    int insertToDo(Connection conn, TodoDTO dto) throws SQLException;

    // 할일 수정
    int updateTodo(Connection conn, TodoDTO dto) throws SQLException;
    
    // 할일 삭제
    int deleteTodo(Connection conn, long dto) throws SQLException;


}
