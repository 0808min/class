package com.app.board.util;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Component     // fileSaveUtil
@Log4j2
public class FileSaveUtil {


    // 새 메소드는 => MultipartFile 을 받아서 저장, 저장 파일 을 반환
    public Map<String, Object> saveFile(MultipartFile file){

        File saveDir = null;
        String newFileName = null;


        if(file != null && !file.isEmpty() && file.getSize()>0){

            String absolutePath = new File("").getAbsolutePath();
            log.info(absolutePath);

            String path = "photo";
            saveDir = new File(absolutePath, path);

            // 폴더가 존재하지 않으면 생성
            if(!saveDir.exists()){
                saveDir.mkdir();
                log.info(">>>>>  photo dir 생성");
            }

            String uuid = UUID.randomUUID().toString();
            // 새로운 파일으 이름을 생성
            newFileName = uuid+file.getOriginalFilename();
            // 새로운 저장 파일의 경로
            File newFile = new File(saveDir, newFileName);

            try {
                // 파일 저장
                file.transferTo(newFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("newFileName", newFileName);
        resultMap.put("saveDir", saveDir);

        return resultMap;
    }
}
