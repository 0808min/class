package com.app.board.service.board;

import com.app.board.domain.BoardDTO;
import com.app.board.domain.BoardEditRequest;
import com.app.board.entity.Board;
import com.app.board.mapper.BoardMapper;
import com.app.board.repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.UUID;

@Service
@Log4j2
public class BoardEditService {

    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private BoardRepository boardRepository;

    public int edit(BoardEditRequest boardEditRequest){

        MultipartFile file = boardEditRequest.getFormFile();

        File saveDir = null;
        String newFileName = null;

        if(file != null && !file.isEmpty()) {

            // 새로운 파일을 저장
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
                log.info("newFileName >>>>>>>>>>> " + newFileName);
            } catch (IOException e) {

                log.info("IOException ... ");
                throw new RuntimeException(e);
            }

        }

        // BoardDTO boardDTO = boardEditRequest.toBoardDTO();

        // Request -> Entity
        Board board = boardEditRequest.toBoardEntity();
        if(newFileName != null){
            board.setPhoto(newFileName);
        } else {
            board.setPhoto(null);
        }

        log.info(board);

        int result = 0;


        try {
            // db update
            //result = boardMapper.update(boardDTO);

            // 수정 시간 설정
            board.setUpdatedate(LocalDate.now());

            boardRepository.save(board);

            // 새로운 파일이 저장 되고 이전 파일이 존재한다면 ! -> 이전 파일을 삭제
            String oldFileName = boardEditRequest.getOldFile();
            if(newFileName !=null && oldFileName != null && !oldFileName.isEmpty()){
                File delOldFile = new File(saveDir,oldFileName);
                if(delOldFile.exists()){
                    delOldFile.delete();
                    log.info(oldFileName + " 파일 삭제  ");
                }
            }


        } catch (Exception e) {

            log.info("SQLException ....");
            // 새롭게 저장된 파일 삭제
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
