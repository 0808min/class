package com.mini.librarymanager.Service;


import com.mini.librarymanager.DAO.BoardDAO;
import com.mini.librarymanager.DAO.CommentDAO;
import com.mini.librarymanager.domain.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	private BoardDAO boardDAO;
	private CommentDAO commentDAO;

	@Autowired
	public BoardService(BoardDAO _boardDAO, CommentDAO _commentDAO) {
		this.boardDAO = _boardDAO;
		this.commentDAO = _commentDAO;
	}

	public void updatePublic(BoardDTO _boardDTO, String inputBoardPublic) {
		// 게시글 공개 여부 설정
		boardDAO.updatePublic(_boardDTO, inputBoardPublic);
	}

	// 게시글 마지막 댓글 아이디 가져오기
	public int findLatestCID(int inputFBID) {
		return commentDAO.findLatestCID(inputFBID);
	}
}
