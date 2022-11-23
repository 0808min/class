package com.todo.todospring.service;

import com.todo.todospring.dao.MemberDao;
import com.todo.todospring.domain.Member;
import com.todo.todospring.util.ConnectionProvider;
import lombok.Cleanup;
import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service
public class LoginService {


    private MemberDao memberDao;

    public LoginService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public Member login(String uid, String pw) throws Exception {
        @Cleanup Connection conn = ConnectionProvider.getInstance().getConnection();
        return memberDao.selectByIdPw(conn, uid, pw);
    }
}
