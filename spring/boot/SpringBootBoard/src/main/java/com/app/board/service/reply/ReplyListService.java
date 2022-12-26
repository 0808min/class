package com.app.board.service.reply;

import com.app.board.domain.ReplyDTO;
import com.app.board.entity.Reply;
import com.app.board.mapper.ReplyMapper;
import com.app.board.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyListService {

    @Autowired
    private ReplyMapper replyMapper;

    @Autowired
    private ReplyRepository replyRepository;

    public List<Reply> selectAll(int bno){
        //return replyMapper.selectAll(bno);
        return replyRepository.findByBno(bno);
    }

}
