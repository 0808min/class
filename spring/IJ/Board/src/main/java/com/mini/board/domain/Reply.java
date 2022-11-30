package com.mini.board.domain;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Reply {

    private int mo;
    private int bno;
    private String reply;
    private String replyer;
    private String replyDate;
    private String updateDate;

}
