package com.app.board.service;

import com.app.board.domain.BoardDTO;
import com.app.board.domain.BoardEditRequest;
import com.app.board.mapper.BoardMapper;
import lombok.Setter;
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
public class BoardEditService {

    @Autowired
    private BoardMapper boardMapper;

    public int edit(BoardEditRequest boardEditRequest) {

        MultipartFile file = boardEditRequest.getPhoto();

        File saveDir = null;
        String newFileName = null;

        if(file != null && !file.isEmpty()) {

            // 새로운 파일을 저장

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


        BoardDTO boardDTO = boardEditRequest.toBoardDTO();
        if(newFileName != null) {
            boardDTO.setPhoto(newFileName);
        }

        int result = 0;

        try {
            // db update
            result = boardMapper.update(boardDTO);

            // 새로운 파일이 저장되고 이전 파일이 존재한다면 -> 이전 파일을 삭제
            String oldPhotoName = boardEditRequest.getOldphoto();
            if (newFileName != null && oldPhotoName != null && !oldPhotoName.trim().isEmpty()){
                File deleteOldPhoto = new File(saveDir, oldPhotoName);

                if (deleteOldPhoto.delete()){

                }
            }

        } catch (SQLException e) {
            // 새롭게 저장된 파일을 삭제
            if(newFileName != null) {
                File delFile = new File(saveDir, newFileName);
                if(delFile.exists()) {

                    delFile.delete();
                }
            }
        }

        return result;
    }

}
