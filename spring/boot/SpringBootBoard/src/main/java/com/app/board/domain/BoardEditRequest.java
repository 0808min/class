package com.app.board.domain;

<<<<<<< HEAD
import com.app.board.entity.Board;
import com.app.board.entity.BoardMember;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
=======
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
@Getter
@Setter
@ToString
@Builder
public class BoardEditRequest {

    private int bno;
<<<<<<< HEAD
    private int curPageNum;
    private String title;
    private Integer writer;     // String -> Integer
    private String content;
    private String oldFile;
    private MultipartFile formFile;

    /*public BoardDTO toBoardDTO(){
=======
    private int currPageNum;
    private String title;
    private String writer;
    private String content;
    private String oldphoto;
    private MultipartFile photo;

    public BoardDTO toBoardDTO() {
>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
        return BoardDTO.builder()
                .bno(bno)
                .writer(writer)
                .title(title)
                .content(content)
<<<<<<< HEAD
                .photo(oldFile)
                .build();
    }*/

    public Board toBoardEntity(){
        return Board.builder()
                .bno(bno)
                .writer(BoardMember.builder().idx(writer).build())
                .title(title)
                .content(content)
                .photo(oldFile)
                .build();
    }



=======
                .photo(oldphoto)
                .build();

    }

>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
}
