package com.app.board.service.reply;

import com.app.board.domain.ReplyDTO;
import com.app.board.entity.Reply;
import com.app.board.mapper.ReplyMapper;
import com.app.board.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReplyReadService {

    @Autowired
    private ReplyMapper replyMapper;

    @Autowired
    private ReplyRepository replyRepository;

    @Transactional
    public Reply selectByRno(int rno){

        replyRepository.flush();
        //return replyMapper.selectByRno(rno);
        //     replyRepository.findById(35).get()
        return replyRepository.findById(rno).get();
    }


}
