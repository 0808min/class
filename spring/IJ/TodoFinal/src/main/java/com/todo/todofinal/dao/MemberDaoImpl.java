package com.todo.todofinal.dao;

import com.todo.todofinal.domain.Member;
import lombok.Cleanup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class MemberDaoImpl implements MemberDao {



    @Override
    public int insertMember(Connection conn, Member member) throws SQLException {

        String sql = "insert into member (uid, pw, uname, uphoto) values (?, ?, ?, ?)";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, member.getUid());
        pstmt.setString(2, member.getPw());
        pstmt.setString(3, member.getUname());
        pstmt.setString(4, member.getUphoto());

        return pstmt.executeUpdate();
    }

}
