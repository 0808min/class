package com.app.mall.service.member;

import com.app.mall.domain.member.MemberRegRequest;
import com.app.mall.repository.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class MemberRegService {

    @Autowired
    private MemberRepository memberRepository;

    public int insetMember(MemberRegRequest regRequest) {

        MultipartFile file = regRequest.getUphoto();

        File saveDir = null;
        String newFileName = null;

        if(file != null && !file.isEmpty() && file.getSize()>0) {
            String absolutPath = new File("")
        }


    }

}
