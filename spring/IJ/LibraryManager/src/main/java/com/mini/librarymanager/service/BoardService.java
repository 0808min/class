package com.mini.librarymanager.Service;

import org.springframework.beans.factory.annotation.*;
import java.util.*;
import org.springframework.stereotype.*;

import com.mini.librarymanager.DAO.*;
import com.mini.librarymanager.DTO.*;

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
