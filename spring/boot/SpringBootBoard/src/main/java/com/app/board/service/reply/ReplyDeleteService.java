package com.app.board.service.reply;

import com.app.board.entity.Reply;
import com.app.board.mapper.ReplyMapper;
import com.app.board.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyDeleteService {

    @Autowired
    private ReplyMapper replyMapper;

    @Autowired
    private ReplyRepository replyRepository;

    public int deleteByRno(int rno){
        //return replyMapper.deleteByRno(rno);
        return replyRepository.deleteByRno(rno);
    }
}
