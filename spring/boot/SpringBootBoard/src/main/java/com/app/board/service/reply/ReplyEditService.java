package com.app.board.service.reply;

import com.app.board.domain.ReplyDTO;
import com.app.board.entity.Reply;
import com.app.board.mapper.ReplyMapper;
import com.app.board.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReplyEditService {

    @Autowired
    private ReplyMapper replyMapper;

    @Autowired
    private ReplyRepository replyRepository;

    public int updateReply(ReplyDTO replyDTO){

        Reply reply = replyDTO.toReplyEntity();
        reply.setUpdatedate(LocalDate.now());
        reply.setReplydate(LocalDate.parse(replyDTO.getReplydate()));

        return replyRepository.save(reply) != null ? 1 : 0;

        //return replyMapper.updateReply(replyDTO);
    }

}
