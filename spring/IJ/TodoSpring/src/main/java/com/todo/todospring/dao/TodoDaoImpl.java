package com.todo.todospring.dao;


import com.todo.todospring.domain.Member;
import com.todo.todospring.domain.TodoDTO;
import lombok.Cleanup;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository(value = "todoDao")
public class TodoDaoImpl implements TodoDao {

    @Override
    public List<TodoDTO> selectAll(Connection conn) throws SQLException {

        List<TodoDTO> result = null;

        @Cleanup PreparedStatement pstmt = conn.prepareStatement("Select * from tbl_todo");
        @Cleanup ResultSet rs = pstmt.executeQuery();

        // 결과 row 체크 후 반복 여부 진행
        if (rs.next()){
            result = new ArrayList<>();
            do {
                result.add(toTodoDto(rs));
            } while (rs.next());
        } else {
            // 비어 있는 리스트 생성 : null 값으로 반화할 경우 상황에 따라 null 비교하는 구문이 필요!!
            result = Collections.emptyList();;
        }

        return result;
    }

    private TodoDTO toTodoDto(ResultSet rs) throws SQLException {

        TodoDTO dto = new TodoDTO(
                rs.getLong(1),
                rs.getString(2),
                rs.getDate(3).toLocalDate(),
                rs.getBoolean(4));

        /*
        TodoDTO dto = TodoDTO.builder()
            .tno(rs.getLong(1))
            .todo(rs.getString(2))
            .dueDate(rs.getDate(3).toLocalDate())
            .finished(rs.getBoolean(4))
            .build();
        */

        return dto;

    }

    @Override
    public TodoDTO selectByTno(Connection conn, long tno) throws SQLException {

        TodoDTO todoDTO = null;

        @Cleanup PreparedStatement pstmt = conn.prepareStatement("Select * from tbl_todo where tno=?");
        pstmt.setLong(1, tno);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        if(rs.next()){
            todoDTO = toTodoDto(rs);
        }

        return todoDTO;
    }

    @Override
    public int insertToDo(Connection conn, TodoDTO dto) throws SQLException {

        int result = 0;
        String sql = "insert into tbl_todo (todo, dueDate) values (?, ?)";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, dto.getTodo());
        pstmt.setDate(2, Date.valueOf(dto.getDueDate()));
        result = pstmt.executeUpdate();

        return result;
    }

    @Override
    public int updateTodo(Connection conn, TodoDTO dto) throws SQLException {

        int result = 0;
        String sql = "update tbl_todo set todo=?, duedate=?, finished=? where tno=?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, dto.getTodo());
        pstmt.setDate(2, Date.valueOf(dto.getDueDate()));
        pstmt.setBoolean(3, dto.isFinished());
        pstmt.setLong(4, dto.getTno());
        result = pstmt.executeUpdate();

        return result;
    }

    @Override
    public int deleteTodo(Connection conn, long dto) throws SQLException {

        int result = 0;
        String sql = "delete from tbl_todo where tno=?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1, dto);
        result = pstmt.executeUpdate();

        return result;
    }


}
