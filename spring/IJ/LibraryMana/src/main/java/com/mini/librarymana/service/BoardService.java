package com.mini.librarymana.service;

import com.mini.librarymana.domain.BoardDTO;
import com.mini.librarymana.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BoardService {

    @Autowired(required = false)
    private BoardMapper boardMapper;

    public List<BoardDTO> getTodoList() {
        List<BoardDTO> list = null;
        try {
            list = boardMapper.showAll();
        } catch (Exception e) {
            e.printStackTrace();
            list = Collections.emptyList();
        }
        return list;
    }

}
