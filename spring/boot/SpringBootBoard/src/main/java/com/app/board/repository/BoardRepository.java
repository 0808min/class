package com.app.board.repository;

import com.app.board.entity.Board;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BoardRepository extends JpaRepository<Board, Integer> {

    // 리스트 페이지 : findAll()
    // 뷰 페이지 : findById()
    // 수정  :   save()
    // 입력  :  save()
    // 삭제  : 별도 메소드 생성 => int, @Transactional 반드시 추가

    @Transactional
    @Modifying  // insert, update, delete
    /*@Query("delete from Board b where b.bno = ?1")*/
    @Query("delete from Board b where b.bno = :bno")
    int deleteByBno(@Param("bno") Integer bno);



}
