package com.app.board.mapper;

import com.app.board.domain.ReplyDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReplyMapper {

    @Select("select * from tbl_reply where bno=#{bno}")
    List<ReplyDTO> selectAll(int bno);


    @Select("select * from tbl_reply where rno=#{rno}")
    ReplyDTO selectByRno(int rno);


    @Insert("INSERT INTO tbl_reply (bno,reply,replyer) VALUES (#{bno}, #{reply}, #{replyer})")
    @Options(useGeneratedKeys = true, keyProperty = "rno", keyColumn = "rno")
    int insertReply(ReplyDTO replyDTO);

    @Delete("delete from tbl_reply where rno=#{rno}")
    int deleteByRno(int rno);

    @Update("update tbl_reply set bno=#{bno}, reply=#{reply}, replyer=#{replyer}, replydate=#{replydate}, updatedate=now() where rno=#{rno} ")
    int updateReply(ReplyDTO replyDTO);


}
