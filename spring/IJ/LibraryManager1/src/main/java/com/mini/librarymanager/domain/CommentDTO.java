package com.mini.librarymanager.domain;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CommentDTO {

    private int cid;
    private int fbid;
    private String email;
    private String content;

}
