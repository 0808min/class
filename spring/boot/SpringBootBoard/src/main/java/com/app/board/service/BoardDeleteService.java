package com.app.board.service;

import com.app.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class BoardDeleteService {

    @Autowired
    private BoardMapper boardMapper;

    public int delete(int bno) {

        return boardMapper.deleteByBno(bno);

    }

}
