package com.app.board;

import com.app.board.domain.BoardEditRequest;
import com.app.board.domain.BoardWriteRequest;
import com.app.board.entity.Board;
import com.app.board.repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
@Log4j2
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void saveTest(){

        /*
        BoardWriteRequest -> Entity -> save()
        */

        /*BoardWriteRequest writeRequest = BoardWriteRequest.builder()
                .title("12월 16일 JPA 테스트 작성")
                .writer("JPA")
                .content("테스트 실행!")
                .build();

        Board board = writeRequest.toBoardEntity();

        log.info("insert 전 : " + board);

        log.info("insert 후 : " + boardRepository.save(board)   );*/

    }

    @Test
    public void findIdTest(){

        // view 페이지 , edit form
        Optional<Board> result = boardRepository.findById(128);

        Board board = result.get();

        log.info("128번 게시물  >>>>> " + board);

    }


    @Test
    public void editTest(){

        BoardEditRequest editRequest = BoardEditRequest.builder()
                .bno(128)
                .title("12월 16일에 변경")
                .content("내용 수정")
                .build();

        // requet => entity
        Board board = editRequest.toBoardEntity();
        board.setUpdatedate(LocalDate.now());

        log.info("수정 전 데이터 >>>>> " + board);

        Board editBoard = boardRepository.save(board);

        log.info("수정 후 데이터 >>>>> " + editBoard);

    }


    @Test
    public void deleteTest(){
        int result = boardRepository.deleteByBno(129);
        log.info(">>>>>  결과 >>>>>> " + result);
    }

    @Test
    public void listTest(){
        // 페이징 -> 구간 select, 한 페이지에 10개씩 게시물이 출력
        Page<Board> page = boardRepository.findAll(PageRequest.of(0, 10, Sort.by("bno").descending()));

        // 전체 페이지 개수
        long totalCnt = page.getTotalElements();
        log.info(">>>>>>> 전체 게시물의 개수  ::::: " + totalCnt);
        // 게시물 리스트
        for (Board board : page.getContent()){
            log.info(board);
        }
    }

}
