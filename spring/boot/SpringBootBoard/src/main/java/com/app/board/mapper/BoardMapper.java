package com.app.board.mapper;

<<<<<<< HEAD
import com.app.board.domain.BoardArticleDTO;
=======
>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
import com.app.board.domain.BoardDTO;
import org.apache.ibatis.annotations.*;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface BoardMapper {

    @Select("select * from tbl_board")
    List<BoardDTO> selectAll();

<<<<<<< HEAD
    //@Select("select * from tbl_board order by bno desc limit #{start},#{count}")
    //List<BoardDTO> selectList(@Param("start") int start, @Param("count") int count);

    @Select("select *, (select count(*) from tbl_reply r  where r.bno=b.bno) as replycnt from tbl_board b order by b.bno desc limit #{start},#{count}")
    List<BoardArticleDTO> selectList(@Param("start") int start, @Param("count") int count);
=======
    @Select("select * from tbl_board order by bno desc limit #{start},#{count}")
    List<BoardDTO> selectList(@Param("start") int start, @Param("count") int count);
>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135

    @Select("select count(*) from tbl_board")
    Integer totalCount();

    // 게시글 하나의 정보
    @Select("select * from tbl_board where bno=#{no}")
    BoardDTO selectByBno(int bno);

<<<<<<< HEAD
    @Insert("insert into tbl_board (title, content, writer, photo) values (#{title}, #{content}, #{writer}, #{photo})")
    Integer insert(BoardDTO boardDTO) throws SQLException;

=======
>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
    @Delete("delete from tbl_board where bno=#{bno}")
    Integer deleteByBno(int bno);

    @Update("update tbl_board set title=#{title}, content=#{content}, writer=#{writer}, photo=#{photo}, updatedate=now() where bno=#{bno}")
    Integer update(BoardDTO boardDTO) throws SQLException;

<<<<<<< HEAD
=======
    @Insert("insert into tbl_board(title, content, writer, photo) values(#{title}, #{content}, #{writer}, #{photo})")
    Integer insert(BoardDTO boardDTO) throws SQLException;




>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
}
