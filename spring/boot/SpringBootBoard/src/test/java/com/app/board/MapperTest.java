package com.app.board;

<<<<<<< HEAD
import com.app.board.domain.BoardDTO;
import com.app.board.mapper.BoardMapper;
=======

import com.app.board.domain.BoardDTO;
import com.app.board.mapper.BoardMapper;
import lombok.ToString;
>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

<<<<<<< HEAD
=======
import javax.swing.*;
>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
import java.util.List;

@SpringBootTest
@Log4j2
public class MapperTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
<<<<<<< HEAD
    public void mapperTest(){

        //List<BoardDTO> list1 = boardMapper.selectAll();
        //log.info("board List ::::::::::::::: " + list1);

        // 1페이지 : 10개의 게시물
//        List<BoardDTO> list1 = boardMapper.selectList(30, 10);
//        log.info(list1);

    }



=======
    public void mapperTest() {

//        List<BoardDTO> list1 = boardMapper.selectAll();
//        log.info("board list ::::::::::::::: " + list1);

        List<BoardDTO> list1 = boardMapper.selectList(30, 10);
        log.info(list1);

    }
>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
}
