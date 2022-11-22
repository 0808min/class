package com.todo.todofinal.dao;

import com.todo.todofinal.domain.Member;

import java.sql.Connection;
import java.sql.SQLException;

public interface MemberDao {

    int insertMember(Connection conn, Member member) throws SQLException;
}
