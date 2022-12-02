package com.mini.librarymanager.DAO;

import com.mini.librarymanager.DTO.*;
import org.springframework.stereotype.*;
import org.springframework.jdbc.core.*;

import javax.sql.*;
import java.util.*;

@Component
public class NoticeDAO {
	private NoticeDTO noticeDTO;
	private JdbcTemplate jdbcTemplate;

	public NoticeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public NoticeDTO selectByID(int inputID) {
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM NOTICE WHERE ID=?;",
					(rs, rowNum) -> new NoticeDTO(rs.getInt("ID"), rs.getString("TITLE"), rs.getDate("DATE"),
							rs.getString("CONTENT")),
					inputID);
		} catch (Exception ex) {
			return null;
		}
	}

	public List<NoticeDTO> showAll() {
		List<NoticeDTO> result = jdbcTemplate.query("SELECT * FROM NOTICE;", (rs, rowNum) -> {
			NoticeDTO noticeDTO = new NoticeDTO(rs.getInt("ID"), rs.getString("TITLE"), rs.getDate("DATE"),
					rs.getString("CONTENT"));
			return noticeDTO;
		});
		return result;
	}

	public List<NoticeDTO> showFive() {
		List<NoticeDTO> result = jdbcTemplate.query("SELECT * FROM NOTICE ORDER BY ID DESC LIMIT 5;", (rs, rowNum) -> {
			NoticeDTO noticeDTO = new NoticeDTO(rs.getInt("ID"), rs.getString("TITLE"), rs.getDate("DATE"),
					rs.getString("CONTENT"));
			return noticeDTO;
		});
		return result;
	}

	public void insertNotice(NoticeDTO _noticeDTO) {
		this.noticeDTO = _noticeDTO;

		jdbcTemplate.update("INSERT INTO NOTICE(TITLE, DATE, CONTENT) VALUES('" + noticeDTO.getNoticeTitle()
				+ "', NOW(), '" + noticeDTO.getNoticeContent() + "');");
	}

	public void deleteNotice(NoticeDTO _noticeDTO) {
		this.noticeDTO = _noticeDTO;

		jdbcTemplate.update("DELETE FROM NOTICE WHERE ID=" + _noticeDTO.getNoticeID() + ";");
	}
}