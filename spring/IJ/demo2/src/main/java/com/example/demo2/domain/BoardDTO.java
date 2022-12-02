package com.example.demo2.domain;


import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardDTO {

  private int boardID; // 게시글 아이디
  private String boardEmail; // 게시글 작성자
  private String boardTitle; // 게시글 제목
  private String boardContent; // 게시글 내용
  private Date boardDate; // 게시글 업로드 날짜
  private String boardPublic; // 게시글 공개 여부

}
