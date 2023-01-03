package com.app.board.service.board;

import com.app.board.domain.BoardDTO;
import com.app.board.domain.BoardWriteRequest;
import com.app.board.entity.Board;
import com.app.board.mapper.BoardMapper;
import com.app.board.repository.BoardRepository;
import com.app.board.util.FileSaveUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

@Service
@Log4j2
public class BoardWriteService {

    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private FileSaveUtil fileSaveUtil;

    public int write(BoardWriteRequest boardWriteRequest){

        MultipartFile file = boardWriteRequest.getFormFile();

        /*File saveDir = null;
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

        }*/

        Map<String, Object> saveResult =  fileSaveUtil.saveFile(file);

        String newFileName = (String) saveResult.get("newFileName");
        File saveDir = (File) saveResult.get("saveDir");
        



        // request -> Entity
        //BoardDTO boardDTO = boardWriteRequest.toBoardDTO();
        Board board =boardWriteRequest.toBoardEntity();

        if(newFileName != null){
            board.setPhoto(newFileName);
        }

        int result = 0;

        try {
            // DB insert
            // result = boardMapper.insert(boardDTO);
            result = boardRepository.save(board) != null ? 1 : 0;
        } catch (Exception e){
            if(newFileName!=null){
                File delFile = new File(saveDir, newFileName);
                if(delFile.exists()){
                    // 파일 삭제
                    delFile.delete();
                }
            }
        }

        return result;
    }

}
