package com.mini.librarymanager.DAO;

import javax.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;

import com.mini.librarymanager.DTO.*;

@Component
public class CheckOutDAO {

	@Autowired(required = false)
	private CheckOutDTO checkOutDTO;
	@Autowired(required = false)
	private JdbcTemplate jdbcTemplate;

	public CheckOutDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<CheckOutDTO> selectOverDue() {
		// 연체 도서 받아오기
		List<CheckOutDTO> result = jdbcTemplate.query("SELECT * FROM CHECKOUT WHERE NOW() > RETURN_DUE_DATE;",
				(rs, rowNum) -> {
					CheckOutDTO checkOutDTO = new CheckOutDTO(rs.getString("ISBN"), rs.getString("TITLE"),
							rs.getString("EMAIL"), rs.getDate("RENTAL_DATE"), rs.getDate("RETURN_DUE_DATE"),
							rs.getInt("EXTENSION_COUNT"));
					return checkOutDTO;
				});
		return result;
	}

	public List<CheckOutDTO> showAll() {
		// 모든 대여 도서 받아오기
		List<CheckOutDTO> result = jdbcTemplate.query("SELECT * FROM CHECKOUT;", (rs, rowNum) -> {
			CheckOutDTO checkOutDTO = new CheckOutDTO(rs.getString("ISBN"), rs.getString("TITLE"),
					rs.getString("EMAIL"), rs.getDate("RENTAL_DATE"), rs.getDate("RETURN_DUE_DATE"),
					rs.getInt("EXTENSION_COUNT"));
			return checkOutDTO;
		});
		return result;
	}

	public List<CheckOutDTO> selectByISBN(String bookISBN) {
		// 대여한 도서
		List<CheckOutDTO> result = jdbcTemplate.query("SELECT * FROM CHECKOUT WHERE ISBN='" + bookISBN + "';",
				(rs, rowNum) -> {
					CheckOutDTO checkOutDTO = new CheckOutDTO(rs.getString("ISBN"), rs.getString("TITLE"),
							rs.getString("EMAIL"), rs.getDate("RENTAL_DATE"), rs.getDate("RETURN_DUE_DATE"),
							rs.getInt("EXTENSION_COUNT"));
					return checkOutDTO;
				});
		return result;
	}

	public List<CheckOutDTO> selectByEmail(String memberEmail) {
		// 대여한 도서
		List<CheckOutDTO> result = jdbcTemplate.query("SELECT * FROM CHECKOUT WHERE EMAIL='" + memberEmail + "';",
				(rs, rowNum) -> {
					CheckOutDTO checkOutDTO = new CheckOutDTO(rs.getString("ISBN"), rs.getString("TITLE"),
							rs.getString("EMAIL"), rs.getDate("RENTAL_DATE"), rs.getDate("RETURN_DUE_DATE"),
							rs.getInt("EXTENSION_COUNT"));
					return checkOutDTO;
				});
		return result;
	}

	public void insertCheckOut(String memberEmail, BookDTO bookDTO) {
		// 도서 대여
		jdbcTemplate.update("INSERT INTO CHECKOUT(ISBN, TITLE, EMAIL, RENTAL_DATE, RETURN_DUE_DATE) VALUES('"
				+ bookDTO.getBookISBN() + "', '" + bookDTO.getBookTitle() + "', '" + memberEmail
				+ "', NOW(), DATE_ADD(NOW(), INTERVAL 7 DAY));");
	}

	public void returnCheckOut(String memberEmail, String bookISBN) {
		// 도서 반납
		jdbcTemplate.update("DELETE FROM CHECKOUT WHERE ISBN='" + bookISBN + "' AND EMAIL='" + memberEmail + "';");
	}

	public void extendCheckOut(String memberEmail, String bookISBN) {
		// 도서 연장
		jdbcTemplate.update(
				"UPDATE CHECKOUT SET RETURN_DUE_DATE=DATE_ADD(RETURN_DUE_DATE, INTERVAL 7 DAY), EXTENSION_COUNT=EXTENSION_COUNT+1 WHERE ISBN='"
						+ bookISBN + "' AND EMAIL='" + memberEmail + "';");
	}

	public CheckOutDTO getOneCheckOut(String memberEmail, String bookISBN) {
		// 하나 가져오기
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM CHECKOUT WHERE EMAIL=? AND ISBN=?;",
					(rs, rowNum) -> new CheckOutDTO(rs.getString("ISBN"), rs.getString("TITLE"), rs.getString("EMAIL"),
							rs.getDate("RENTAL_DATE"), rs.getDate("RETURN_DUE_DATE"), rs.getInt("EXTENSION_COUNT")),
					memberEmail, bookISBN);
		} catch (Exception ex) {
			return null;
		}
	}
}
