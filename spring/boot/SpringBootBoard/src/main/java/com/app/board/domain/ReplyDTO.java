package com.app.board.domain;


import com.app.board.entity.BoardMember;
import com.app.board.entity.Reply;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ReplyDTO {

    private int rno;
    private int bno;
    private String reply;

    private Integer replyer;   //String -> int 회원의 idx

    private String replydate;
    private String updatedate;

    public Reply toReplyEntity(){
        return Reply.builder()
                .rno(rno)
                .bno(bno)
                .reply(reply)
                .replyer(BoardMember.builder().idx(replyer).build())
                /*.replyer(replyer)*/
                /*.replydate(LocalDate.parse(replydate) )*/
                .build();
    }

}
