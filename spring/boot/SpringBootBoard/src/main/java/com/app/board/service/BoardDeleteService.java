package com.app.board.service;

import com.app.board.domain.BoardDTO;
import com.app.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service

public class BoardDeleteService {

    @Autowired
    private BoardMapper boardMapper;

    public int delete(int bno) {

        // 삭제 하려는 게시물의 데이터
        BoardDTO boardDTO = boardMapper.selectByBno(bno);

        //삭제 결과 확인
        int result = boardMapper.deleteByBno(bno);

        // 해당 게시물이 DB에서 삭제 되고, 해당 게시물의 사진 이름을 가지고 있다면 -> 파일 삭제
        if(result>0 && boardDTO.getPhoto() != null) {

            File delFile = new File(new File("").getAbsolutePath(), "photo"+ File.pathSeparator+boardDTO.getPhoto());
            if(delFile.exists()) {
                delFile.delete();
            }

        }

        return result;

    }

}
