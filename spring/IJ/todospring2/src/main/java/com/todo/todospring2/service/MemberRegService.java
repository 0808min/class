package com.todo.todospring2.service;

import com.todo.todospring2.dao.MemberDao;
import com.todo.todospring2.domain.Member;
import com.todo.todospring2.domain.MemberRegRequest;
import com.todo.todospring2.util.ConnectionProvider;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;

@Service
@Log4j2
public class MemberRegService {


    private MemberDao memberDao;

    public MemberRegService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }


    // 사용자 요청 데이터를 받고, 파일 업로드 처리, Dao insert 요청
    public int memberReg(MemberRegRequest regRequest, HttpServletRequest request) throws Exception {

        String newFileName = null;

        // 파일 업로드 처리여부 체크
        if(regRequest.getUphoto() != null && !regRequest.getUphoto().isEmpty()
                && regRequest.getUphoto().getSize()>0) {

            // URI 정의 : 저장 할 폴더
            String dirURI = "/uploadfile/member";
            // 시스템 절대 경로
            String dirRealpath = request.getSession().getServletContext().getRealPath(dirURI);
            log.info(dirRealpath);

            newFileName = System.nanoTime() + regRequest.getUphoto().getOriginalFilename();
            log.info(newFileName);

            // 저장처리
            try {
                regRequest.getUphoto().transferTo(new File(dirRealpath, regRequest.getUphoto().getOriginalFilename()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }

        Member member = regRequest.toMember();

        if(newFileName != null) {
            member.setUphoto(newFileName);
        }

        log.info(member);

        @Cleanup Connection conn = ConnectionProvider.getInstance().getConnection();


        return memberDao.insertMember(conn, member);
    }

}
