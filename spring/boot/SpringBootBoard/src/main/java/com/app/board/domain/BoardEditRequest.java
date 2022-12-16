package com.app.board.domain;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardEditRequest {

    private int bno;
    private int currPageNum;
    private String title;
    private String writer;
    private String content;
    private String oldphoto;
    private MultipartFile photo;

    public BoardDTO toBoardDTO() {
        return BoardDTO.builder()
                .bno(bno)
                .writer(writer)
                .title(title)
                .content(content)
                .photo(oldphoto)
                .build();

    }

}
