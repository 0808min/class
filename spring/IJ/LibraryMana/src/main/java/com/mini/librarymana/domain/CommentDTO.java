package com.mini.librarymana.domain;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CommentDTO {

    private int commentID;
    private int commentBoardID;
    private String commentName;
    private String commentContent;

}
