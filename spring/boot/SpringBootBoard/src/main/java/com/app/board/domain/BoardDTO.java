package com.app.board.domain;


import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class BoardDTO {

    private int bno;
    private String title;
    private String content;
    private String writer;
    private String photo;
    private LocalDate regdate;
    private LocalDate updatedate;



}
