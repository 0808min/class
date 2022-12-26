package com.app.board;

import com.app.board.repository.ReplyRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class ReplyRepositoryTest {


    @Autowired
    private ReplyRepository replyRepository ;

    @Test
    public void SelectTest(){
        log.info(replyRepository.findById(35).get());
    }



}
