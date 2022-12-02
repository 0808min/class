package com.mini.librarymanager.DTO;

public class CommentDTO {
	private int commentID;
	private int commentBoardID;
	private String commentName;
	private String commentContent;

	public CommentDTO(int _commentID, int _commentBoardID, String _commentName, String _commentContent) {
		this.commentID = _commentID;
		this.commentBoardID = _commentBoardID;
		this.commentName = _commentName;
		this.commentContent = _commentContent;
	}

	public CommentDTO(int _commentBoardID, String _commentName, String _commentContent) {
		this.commentBoardID = _commentBoardID;
		this.commentName = _commentName;
		this.commentContent = _commentContent;
	}

	public int getCommentID() {
		return commentID;
	}

	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}

	public int getCommentBoardID() {
		return commentBoardID;
	}

	public void setCommentBoardID(int commentBoardID) {
		this.commentBoardID = commentBoardID;
	}

	public String getCommentName() {
		return commentName;
	}

	public void setCommentName(String commentName) {
		this.commentName = commentName;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
}
