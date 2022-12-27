package com.todo.todospring.dao;

import com.todo.todospring.domain.Member;
import lombok.Cleanup;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    @Override
    public Member selectByIdPw(Connection conn, String uid, String pw) throws SQLException {

        String sql = "select * from member where uid=? and pw=?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, uid);
        pstmt.setString(2, pw);

        @Cleanup ResultSet rs = pstmt.executeQuery();

        Member member = null;

        if (rs.next()){
            member = Member.builder()
                    .idx(rs.getInt("idx"))
                    .uid(rs.getString("uid"))
                    .pw(rs.getString("pw"))
                    .uname(rs.getString("uname"))
                    .uphoto(rs.getString("uphoto"))
                    .build();
        }

        return member;
    }
}
