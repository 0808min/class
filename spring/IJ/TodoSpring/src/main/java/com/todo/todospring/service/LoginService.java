package com.todo.todospring.service;

import com.todo.todospring.dao.MemberDao;
import com.todo.todospring.domain.Member;
import com.todo.todospring.util.ConnectionProvider;
import lombok.Cleanup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service
public class LoginService {

    @Autowired
    private MemberDao memberDao;

    public Member login(String uid, String pw) throws Exception {
        @Cleanup Connection conn = ConnectionProvider.getInstance().getConnection();
        return memberDao.selectByIdPw(conn, uid, pw);
    }
}
