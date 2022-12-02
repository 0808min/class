package com.todo.todospring.service;

import com.todo.todospring.domain.Member;
import com.todo.todospring.domain.MemberRegRequest;
import com.todo.todospring.mapper.MemberMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Service
@Log4j2
public class MemberRegService {

    @Autowired(required = false)
    private MemberMapper memberMapper;



    // 사용자 요청 데이터를 받고, 파일 업로드 처리, Dao insert 요청
    public int memberReg(MemberRegRequest regRequest, HttpServletRequest request) throws Exception {

        String newFileName = null;

        // 파일 업로드 처리 여부 체크
        if (regRequest.getUphoto() != null
                && !regRequest.getUphoto().isEmpty()
                && regRequest.getUphoto().getSize() > 0) {

            // 저장할 폴더
            String dirURI = "/uploadfile/member";
            // 절대 경로
            String dirRealpath = request.getSession().getServletContext().getRealPath(dirURI);
            log.info(dirRealpath);

            newFileName = System.nanoTime() + regRequest.getUphoto().getOriginalFilename();
            log.info(newFileName);

            // 저장
            try {
                regRequest.getUphoto().transferTo(new File(dirRealpath, newFileName));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        Member member = regRequest.toMember();

        if (newFileName != null) {
            member.setUphoto(newFileName);
        }

        log.info(member);

        return memberMapper.insertMember(member);
    }

}
