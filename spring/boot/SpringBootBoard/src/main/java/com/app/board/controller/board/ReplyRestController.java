package com.app.board.controller.board;

import com.app.board.domain.ReplyDTO;
import com.app.board.entity.Board;
import com.app.board.entity.Reply;
import com.app.board.service.reply.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reply")
@Log4j2
public class ReplyRestController {

    @Autowired
    private ReplyListService replyListService;

    @Autowired
    private ReplyInsertService replyInsertService;

    @Autowired
    private ReplyReadService replyReadService;

    @Autowired
    private ReplyDeleteService replyDeleteService;


    @Autowired
    private ReplyEditService replyEditService;

    // get  /reply/{bno} => list
    @GetMapping(value = "/{bno}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Reply> selectList(
            @PathVariable("bno") int bno
    ){

        List<Reply> list = replyListService.selectAll(bno);

        //return new ResponseEntity<>(list, HttpStatus.OK);
        return list;

    }



    // post /reply => reply    JSON 데이터를 받아서 DB insert
    @PostMapping
    public ResponseEntity<Reply> insertReply(
        @RequestBody ReplyDTO replyDTO
    ){

        log.info("insert 전 : "+replyDTO);

        // Service -> Mapper
        Reply resultReply = replyInsertService.insertReply(replyDTO);

        log.info("insert 후 : "+resultReply);
        

        //return new ResponseEntity<>(replyReadService.selectByRno(replyDTO.getRno()), HttpStatus.OK);
        return new ResponseEntity<>(resultReply, HttpStatus.OK);

    }

    // put  /reply/{rno} => reply
    @PutMapping("/{rno}")
    public ResponseEntity<Integer> editReply(
            @RequestBody ReplyDTO replyDTO,
            @PathVariable("rno") int rno
    ){
        replyDTO.setRno(rno);
        return new ResponseEntity<>(replyEditService.updateReply(replyDTO), HttpStatus.OK);
    }

    // delete /reply/{rno} => 0 / 1, success, fail
    @DeleteMapping("/{rno}")
    public ResponseEntity<Integer> delete(
            @PathVariable("rno") int rno
    ){
        return new ResponseEntity<>(replyDeleteService.deleteByRno(rno), HttpStatus.OK);
    }





}
