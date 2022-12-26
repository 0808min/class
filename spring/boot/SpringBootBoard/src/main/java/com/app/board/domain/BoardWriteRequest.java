package com.app.board.domain;

<<<<<<< HEAD
import com.app.board.entity.Board;
import com.app.board.entity.BoardMember;
=======
>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
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
<<<<<<< HEAD
    
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


=======
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

>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
}
