package com.mini.librarymanager.domain;


import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardDTO {

  private int fbid;
  private String email;
  private String title;
  private String content;
  private String date;
  private String PUBLIC;

}
