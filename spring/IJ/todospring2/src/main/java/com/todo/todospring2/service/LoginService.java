package com.todo.todospring2.service;

import com.todo.todospring2.dao.MemberDao;
import com.todo.todospring2.domain.Member;
import com.todo.todospring2.util.ConnectionProvider;
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

