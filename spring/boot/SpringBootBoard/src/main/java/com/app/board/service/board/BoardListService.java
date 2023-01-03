package com.app.board.service.board;

import com.app.board.domain.BoardArticleDTO;
import com.app.board.domain.BoardDTO;
import com.app.board.domain.BoardListPage;
import com.app.board.entity.Board;
import com.app.board.mapper.BoardMapper;
import com.app.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardListService {

    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private BoardRepository boardRepository;


    public BoardListPage getPage(int pageNum){

        Page<Board> page = boardRepository.findAll(PageRequest.of(pageNum-1, 10, Sort.by("bno").descending()));

        // 게시물의 리스트
        //List<BoardArticleDTO> list = boardMapper.selectList((pageNum-1)*10, 10);
        List<Board> list = page.getContent();
        
        // 전체 게시물의 개수
        //int totalCount = boardMapper.totalCount();
        int totalCount = (int) page.getTotalElements();

        BoardListPage boardListPage = new BoardListPage(10, pageNum, list, totalCount);

        return boardListPage;
    }

    public List<BoardArticleDTO> getList(int pageNum){

        int index = (pageNum-1)*10;  // 1->0, 2->10, 3->20, 4->30
        int count = 10;

        return boardMapper.selectList(index,count);

    }

}
