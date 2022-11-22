package com.todo.todospring2.dao;

import com.todo.todospring2.domain.Member;

import java.sql.Connection;
import java.sql.SQLException;

public interface MemberDao {

    int insertMember(Connection conn, Member member) throws SQLException;

    Member selectByIdPw(Connection conn, String uid, String pw) throws SQLException;

}
