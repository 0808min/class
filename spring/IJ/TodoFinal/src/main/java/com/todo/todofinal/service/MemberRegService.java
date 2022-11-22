package com.todo.todofinal.service;

import com.todo.todofinal.dao.MemberDao;
import com.todo.todofinal.domain.Member;
import com.todo.todofinal.domain.MemberRegRequset;
import com.todo.todofinal.util.ConnectionProvider;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;

@Log4j2
@Service
public class MemberRegService {

    private MemberDao memberDao;

    // 사용자 요청 데이터를 받고, 파일 업로드 처리, dao에 insert 요청
    public int memberReg(MemberRegRequset regRequset, HttpServletRequest request) throws Exception {

        String newFileName = null;

        // 파일 업로드 처리 여부 체크
        if (regRequset.getUphoto() != null && !regRequset.getUphoto().isEmpty()
                && regRequset.getUphoto().getSize() > 0) {

            // 저장 할 폴더
            String dirURI = "/uploadfile/member";

            // 경로
            String dirRealPath = request.getSession().getServletContext().getRealPath(dirURI);
            log.info(dirRealPath);

            newFileName = System.nanoTime() + regRequset.getUphoto().getOriginalFilename();
            log.info(newFileName);


            // 저장
            try {
                regRequset.getUphoto().transferTo(new File(dirRealPath, newFileName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }

        Member member = regRequset.toMember();

        if(newFileName != null){
            member.setUphoto(newFileName);
        }

        log.info(member);

       @Cleanup Connection conn = ConnectionProvider.getInstance().getConnection();

        return memberDao.insertMember(conn, member);

    }


}
