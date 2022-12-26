package com.app.board;


import com.app.board.domain.BoardDTO;
import com.app.board.mapper.BoardMapper;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.*;
import java.util.List;

@SpringBootTest
@Log4j2
public class MapperTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void mapperTest() {

//        List<BoardDTO> list1 = boardMapper.selectAll();
//        log.info("board list ::::::::::::::: " + list1);

        List<BoardDTO> list1 = boardMapper.selectList(30, 10);
        log.info(list1);

    }
}
