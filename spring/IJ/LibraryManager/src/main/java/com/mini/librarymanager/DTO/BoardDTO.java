package com.mini.librarymanager.DTO;

import java.sql.*;

public class BoardDTO {
	private int boardID; // 게시글 아이디
	private String boardEmail; // 게시글 작성자
	private String boardTitle; // 게시글 제목
	private String boardContent; // 게시글 내용
	private Date boardDate; // 게시글 업로드 날짜
	private String boardPublic; // 게시글 공개 여부

	public BoardDTO(int _boardID, String _boardEmail, String _boardTitle, String _boardContent, Date _boardDate,
			String _boardPublic) {
		// 게시판 데이터 받아올 때
		this.boardID = _boardID;
		this.boardEmail = _boardEmail;
		this.boardTitle = _boardTitle;
		this.boardContent = _boardContent;
		this.boardDate = _boardDate;
		this.boardPublic = _boardPublic;
	}

	public BoardDTO(String _boardEmail, String _boardTitle, String _boardContent) {
		// 게시글 작성 시
		this.boardEmail = _boardEmail;
		this.boardTitle = _boardTitle;
		this.boardContent = _boardContent;
	}

	public int getBoardID() {
		return boardID;
	}

	public void setBoardID(int boardID) {
		this.boardID = boardID;
	}

	public String getBoardEmail() {
		return boardEmail;
	}

	public void setBoardEmail(String boardEmail) {
		this.boardEmail = boardEmail;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public String getBoardPublic() {
		return boardPublic;
	}

	public void setBoardPublic(String boardPublic) {
		this.boardPublic = boardPublic;
	}

}
