package com.app.board.service;

import com.app.board.domain.BoardDTO;
import com.app.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardListService {

    @Autowired
    private BoardMapper boardMapper;

    public List<BoardDTO> getList(int pageNum){

        int index = (pageNum-1)*10;  // 1->0 2->10 3->20 4->30
        int count = 10;

        return boardMapper.selectList(index, count);

    }



}
