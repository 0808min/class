package com.mini.librarymanager.DTO;

import java.sql.Date;

public class NoticeDTO {
	private int noticeID; // 공지 아이디 -- Primary Key, Auto_Increment
	private String noticeTitle; // 공지 제목
	private Date noticeDate; // 공지 날짜
	private String noticeContent; // 공지 콘텐츠

	public NoticeDTO(String _noticeTitle, String _noticeContent) {
		// 공지 새로 추가할 때
		this.noticeTitle = _noticeTitle;
		this.noticeContent = _noticeContent;
	}

	public NoticeDTO(int _noticeID, String _noticeTitle, Date _noticeDate, String _noticeContent) {
		// 공지 받아올 때
		this.noticeID = _noticeID;
		this.noticeTitle = _noticeTitle;
		this.noticeDate = _noticeDate;
		this.noticeContent = _noticeContent;
	}

	public int getNoticeID() {
		return noticeID;
	}

	public void setNoticeID(int noticeID) {
		this.noticeID = noticeID;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
}
