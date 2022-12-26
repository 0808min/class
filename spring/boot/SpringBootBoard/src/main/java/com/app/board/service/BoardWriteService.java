package com.app.board.service;

import com.app.board.domain.BoardDTO;
import com.app.board.domain.BoardWriteRequest;
import com.app.board.mapper.BoardMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

@Service
@Log4j2
public class BoardWriteService {



    @Autowired
    private BoardMapper boardMapper;

    public int write(BoardWriteRequest boardWriteRequest) {

        MultipartFile file = boardWriteRequest.getPhoto();

        File saveDir = null;
        String newFileName = null;

        if(file != null && !file.isEmpty() && file.getSize()>0) {
            String absolutePath = new File("").getAbsolutePath();
            log.info(absolutePath);

            String path = "photo";
            saveDir = new File(absolutePath, path);

            // 폴더가 존재하지 않으면 생성
            if(!saveDir.exists()) {
                saveDir.mkdir();
                log.info(">>>>>> photo Dir 생성");
            }

            String uuid = UUID.randomUUID().toString();

            // 새로운 파일의 이름 생성
            newFileName = uuid+file.getOriginalFilename();

            // 새로운 저장파일의 경로
            File newfile = new File(saveDir, newFileName);

            try {
                // 파일 저장
                file.transferTo(newfile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        BoardDTO boardDTO = boardWriteRequest.toBoardDTO();

        if(newFileName != null) {
            boardDTO.setPhoto(newFileName);
        }

        int result = 0;

        try {
            // DB insert
            boardMapper.insert(boardDTO);
        } catch (SQLException e) {
            if(newFileName != null) {
                File delFile = new File(saveDir, newFileName);
                if(delFile.exists()) {
                    //  파일삭제
                    delFile.delete();
                }
            }
        }



        return result;

    }

}
