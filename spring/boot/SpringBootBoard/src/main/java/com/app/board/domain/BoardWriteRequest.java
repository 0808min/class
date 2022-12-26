package com.app.board.domain;

import com.app.board.entity.Board;
import com.app.board.entity.BoardMember;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardWriteRequest {

    private String title;
    
    // 작성자 이름 문자열 -> 작성자의 idx
    private Integer writer;

    private String content;
    private MultipartFile formFile;


    /*public BoardDTO toBoardDTO(){
        return BoardDTO.builder()
                .title(title)
                .content(content)
                .writer(BoardMember.builder().idx().build())
                .build();
    }*/

    public Board toBoardEntity(){
        return Board.builder()
                .title(title)
                .content(content)
                .writer(BoardMember.builder().idx(writer).build())
                .build();
    }


}
