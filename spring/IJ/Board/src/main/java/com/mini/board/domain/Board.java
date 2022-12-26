package com.mini.board.domain;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NotEmpty
@Getter
@Setter
@ToString
@Builder
public class Board {

    private int bno;
    private String title;
    private String content;
    private String writer;
    private String regDate;
    private String updateDate;

}
