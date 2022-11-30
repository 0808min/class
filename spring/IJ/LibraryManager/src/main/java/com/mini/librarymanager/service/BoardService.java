package com.mini.librarymanager.service;

import com.mini.librarymanager.domain.BoardDTO;
import com.mini.librarymanager.domain.MemberDTO;
import com.mini.librarymanager.mapper.BoardMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class BoardService {

    @Autowired(required = false)
    private BoardMapper boardMapper;


    public List<BoardDTO> getBoardList() {
        List<BoardDTO> list = null;
        try {
            list = boardMapper.showAll();
            log.info(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}

