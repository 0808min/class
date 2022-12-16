package com.app.board.domain;

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
    private String writer;
    private String content;
    private MultipartFile photo;


    public BoardDTO toBoardDTO() {
        return BoardDTO.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .build();
    }

}
