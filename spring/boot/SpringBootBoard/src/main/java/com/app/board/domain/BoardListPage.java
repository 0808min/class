package com.app.board.domain;

<<<<<<< HEAD
import com.app.board.entity.Board;
=======
>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class BoardListPage {

<<<<<<< HEAD
    // 페이지당 출력할 게시물의 개수
=======
    // 페이지 당 출력할 게시물의 개수
>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
    private int countPerPage;

    // 현재 페이지 번호
    private int pageNum;

    // 게시물의 리스트
<<<<<<< HEAD
    //private List<BoardArticleDTO> list;
    private List<Board> list;
=======
    private List<BoardDTO> list;
>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135

    // 전체 게시물의 개수
    private int totalCount;

<<<<<<< HEAD
    // 페이징의 시작 번호
    private int startNum;
    
    // 페이직의 끝 번호
    private int endNum;

    // 이전 번튼 출력 여부
=======
    // 페이지의 시작 번호
    private int startNum;

    // 페이지의 끝 번호
    private int endNum;

    // 이전 버튼 출력 여부
>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
    private boolean prev;

    // 다음 버튼 출력 여부
    private boolean next;

<<<<<<< HEAD
    public BoardListPage(
            int countPerPage,
            int pageNum,
            List<Board> list,
            int totalCount) {
=======
    public BoardListPage(int countPerPage, int pageNum, List<BoardDTO> list, int totalCount) {
>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
        this.countPerPage = countPerPage;
        this.pageNum = pageNum;
        this.list = list;
        this.totalCount = totalCount;
        calPageInfo();
    }

    private void calPageInfo() {

<<<<<<< HEAD
        // 끝번호
        this.endNum = (int)(Math.ceil((this.pageNum * 1.0) / 10)) * 10;    // 11 -> 11.0 / 10 -> 1.1 -> 2.0 -> 2 * 10
        // 1-5     : 5
        // 6-10    : 10
        // 11-15   : 15
        // 시작번호
        this.startNum = this.endNum-9;

        // 전체 페이지의 끝번호
        int realEndNum =    (int)( Math.ceil((this.totalCount * 1.0) / countPerPage));

        // 구간의 막지막 번호보다 실제 페이지 끝번호가 작으면 endNum 은 실제 끝번호가 되어야 한다!!!
        this.endNum = realEndNum < this.endNum ? realEndNum : this.endNum;

        // 이전 구간으로 이동가능한지
        this.prev = this.startNum > 1;

        // 다음 구간 으로 갈수 있는지
=======
        // 끝 번호
        this.endNum = (int)(Math.ceil((this.pageNum * 1.0) / (this.countPerPage * 1.0) / 10)) * 10;   // 1 -> 0.1 / 10 -> 0.1 -> 1

        // 시작 번호
        this.startNum = this.endNum-9;

        // 전체 페이지의 끝 번호
        int realEndNum = (int)(Math.ceil ((this.totalCount * 1.0) / countPerPage));

        // 구간의 마지막 번호보다 실제 페이지 번호가 작으면 endNum 은 실제 끝번호가 되어야 한다.
        this.endNum = realEndNum < this.endNum ? realEndNum : this.endNum;

        // 이전 구간으로 이동 가능한지
        this.prev = this.startNum > 1;

        // 다음 구간으로 이동 가능한지
>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
        this.next = this.endNum < realEndNum;
    }
}
