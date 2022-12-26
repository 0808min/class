package com.app.board;

import com.app.board.entity.BoardMember;
import com.app.board.repository.BoardMemberRespository;
import com.app.board.repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@SpringBootTest
@Log4j2
public class BoardMemberRepositoryTest {

    @Autowired
    private BoardMemberRespository boardMemberRespository;


    @Autowired
    private PasswordEncoder encoder;


    @Test
    public void saveTest(){

        BoardMember boardMember = BoardMember.builder()
                .userid("hot")
                .username("테스터")
                .password(encoder.encode("1111"))
                .role("USER")
                .regdate(LocalDateTime.now())
                .editdate(LocalDateTime.now())
                .build();

        BoardMember member = boardMemberRespository.save(boardMember);

        log.info(member);

    }

}
