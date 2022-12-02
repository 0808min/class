package com.mini.librarymanager.DAO;

import com.mini.librarymanager.domain.BoardDTO;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;



public class BoardDAO {
	private BoardDTO boardDTO;
	private JdbcTemplate jdbcTemplate;

	public BoardDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public BoardDTO selectByFBID(int inputFBID) {
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM BOARD WHERE FBID=?;",
					(rs, rowNum) -> new BoardDTO(rs.getInt("FBID"),
							rs.getString("EMAIL"), rs.getString("TITLE"),
							rs.getString("CONTENT"), rs.getDate("DATE"),
							rs.getString("PUBLIC")), inputFBID);
		} catch (Exception ex) {
			return null;
		}
	}

	public List<BoardDTO> showAll() {
		List<BoardDTO> result = jdbcTemplate.query("SELECT * FROM PROJECT_BOARD;", (rs, rowNum) -> {
			BoardDTO boardDTO = new BoardDTO(rs.getInt("FBID"),
					rs.getString("EMAIL"), rs.getString("TITLE"),
					rs.getString("CONTENT"), rs.getDate("DATE"),
					rs.getString("PUBLIC"));
			return boardDTO;
		});
		return result;
	}

	public List<BoardDTO> showVisibleBoard() {
		List<BoardDTO> result = jdbcTemplate.query("SELECT * FROM BOARD WHERE PUBLIC='Y';", (rs, rowNum) -> {
			BoardDTO boardDTO = new BoardDTO(rs.getInt("FBID"),
					rs.getString("EMAIL"), rs.getString("TITLE"),
					rs.getString("CONTENT"),
					rs.getDate("DATE"), rs.getString("PUBLIC"));
			return boardDTO;
		});
		return result;
	}

	public List<BoardDTO> showThree() {
		List<BoardDTO> result = jdbcTemplate.query("SELECT * FROM BOARD WHERE PUBLIC='Y' ORDER BY FBID DESC LIMIT 3;", (rs, rowNum) -> {
			BoardDTO boardDTO = new BoardDTO(rs.getInt("FBID"),
					rs.getString("EMAIL"), rs.getString("TITLE"),
					rs.getString("CONTENT"), rs.getDate("DATE"),
					rs.getString("PUBLIC"));
			return boardDTO;
		});
		return result;
	}

	public void updatePublic(BoardDTO boardDTO, String newPublic) {
		jdbcTemplate.update("UPDATE BOARD SET PUBLIC='" + newPublic + "' WHERE FBID=" +
				boardDTO.getBoardID() + ";");
	}

	public void insertBoard(String memberEmail, BoardDTO _boardDTO) {
		this.boardDTO = _boardDTO;

		jdbcTemplate.update("INSERT INTO BOARD(EMAIL, TITLE, CONTENT, DATE) VALUES('" + memberEmail + "', '"
				+ boardDTO.getBoardTitle() + "', '" + boardDTO.getBoardContent() + "', NOW());");
	}

	public void deleteBoard(int boardID) {
		jdbcTemplate.update("DELETE FROM BOARD WHERE FBID=" + boardID + ";");
	}
}
