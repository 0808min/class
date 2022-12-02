package com.mini.librarymanager.DAO;

import com.mini.librarymanager.domain.BookDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;



public class BookDAO {
	private BookDTO bookDTO;
	private JdbcTemplate jdbcTemplate;

	public BookDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public BookDTO selectByISBN(String inputISBN) {
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM BOOK WHERE ISBN=?;",
					(rs, rowNum) -> new BookDTO(rs.getString("ISBN"), rs.getString("TITLE"), rs.getString("AUTHOR"),
							rs.getString("GENRE"), rs.getString("PUBLISHER"), rs.getString("IMAGE"), rs.getInt("COUNT"),
							rs.getString("SUMMARY"), rs.getInt("HIT"), rs.getDate("DATE")),
					inputISBN);
		} catch (Exception ex) {
			return null;
		}
	}
	
	public List<BookDTO> genreBook(String inputISBN,String inputGenre) {
		//같은 ISBN 의 책(현재 상세 페이지로 설명이 된 책)을 제외한 관련 장르 책에 대하여 랜덤으로 네개를 받아온다.
		List<BookDTO> result = jdbcTemplate.query("SELECT *  FROM BOOK WHERE ISBN != '"+inputISBN+"' AND GENRE='"+inputGenre+"' ORDER BY RAND() LIMIT 4;", (rs, rowNum) -> {
			BookDTO bookDTO = new BookDTO(rs.getString("ISBN"), rs.getString("TITLE"), rs.getString("AUTHOR"),
					rs.getString("GENRE"), rs.getString("PUBLISHER"), rs.getString("IMAGE"), rs.getInt("COUNT"),
					rs.getString("SUMMARY"), rs.getInt("HIT"), rs.getDate("DATE"));
			return bookDTO;
		});
		return result;
	}
	
	public List<BookDTO> newBook() {
		//가장 최근 날짜에 추가된 도서 10개를 받아온다.
		List<BookDTO> result = jdbcTemplate.query("SELECT * FROM BOOK ORDER BY DATE DESC LIMIT 10;", (rs, rowNum) -> {
			BookDTO bookDTO = new BookDTO(rs.getString("ISBN"), rs.getString("TITLE"), rs.getString("AUTHOR"),
					rs.getString("GENRE"), rs.getString("PUBLISHER"), rs.getString("IMAGE"), rs.getInt("COUNT"),
					rs.getString("SUMMARY"), rs.getInt("HIT"), rs.getDate("DATE"));
			return bookDTO;
		});
		return result;
	}

	public List<BookDTO> showAll() {
		List<BookDTO> result = jdbcTemplate.query("SELECT * FROM BOOK;", (rs, rowNum) -> {
			BookDTO bookDTO = new BookDTO(rs.getString("ISBN"), rs.getString("TITLE"), rs.getString("AUTHOR"),
					rs.getString("GENRE"), rs.getString("PUBLISHER"), rs.getString("IMAGE"), rs.getInt("COUNT"),
					rs.getString("SUMMARY"), rs.getInt("HIT"), rs.getDate("DATE"));
			return bookDTO;
		});
		return result;
	}

	public List<BookDTO> showFive() {
		List<BookDTO> result = jdbcTemplate.query("SELECT * FROM BOOK ORDER BY ISBN DESC LIMIT 5;", (rs, rowNum) -> {
			BookDTO bookDTO = new BookDTO(rs.getString("ISBN"), rs.getString("TITLE"), rs.getString("AUTHOR"),
					rs.getString("GENRE"), rs.getString("PUBLISHER"), rs.getString("IMAGE"), rs.getInt("COUNT"),
					rs.getString("SUMMARY"), rs.getInt("HIT"), rs.getDate("DATE"));
			return bookDTO;
		});
		return result;
	}

	public void insertBook(BookDTO _bookDTO) {
		this.bookDTO = _bookDTO;

		jdbcTemplate.update(
				"INSERT INTO BOOK(ISBN, TITLE, AUTHOR, GENRE, PUBLISHER, IMAGE, COUNT, SUMMARY, HIT, DATE) VALUES('"
						+ bookDTO.getBookISBN() + "', '" + bookDTO.getBookTitle() + "', '" + bookDTO.getBookAuthor()
						+ "', '" + bookDTO.getBookGenre() + "', '" + bookDTO.getBookPublisher() + "', '"
						+ bookDTO.getBookImage() + "', " + bookDTO.getBookCount() + ", '" + bookDTO.getBookSummary()
						+ "', " + bookDTO.getBookHit() + ", NOW());");
	}

	public void deleteBook(BookDTO _bookDTO) {
		this.bookDTO = _bookDTO;

		jdbcTemplate.update("DELETE FROM BOOK WHERE ISBN=" + bookDTO.getBookISBN() + ";");
	}

	public void updateBook(BookDTO _bookDTO) {
		this.bookDTO = _bookDTO;

		jdbcTemplate.update("UPDATE BOOK SET TITLE='" + bookDTO.getBookTitle() + "', AUTHOR='" + bookDTO.getBookAuthor()
				+ "', GENRE='" + bookDTO.getBookGenre() + "', PUBLISHER='" + bookDTO.getBookPublisher() + "', IMAGE='"
				+ bookDTO.getBookImage() + "', COUNT=" + bookDTO.getBookCount() + ", SUMMARY='"
				+ bookDTO.getBookSummary() + "', HIT=" + bookDTO.getBookHit() + " WHERE ISBN='" + bookDTO.getBookISBN()
				+ "';");
	}

	public List<BookDTO> hitBookThree() {
		List<BookDTO> result = jdbcTemplate.query("SELECT * FROM BOOK WHERE HIT >= 5 ORDER BY HIT DESC LIMIT 3;",
				(rs, rowNum) -> {
					BookDTO bookDTO = new BookDTO(rs.getString("ISBN"), rs.getString("TITLE"), rs.getString("AUTHOR"),
							rs.getString("GENRE"), rs.getString("PUBLISHER"), rs.getString("IMAGE"), rs.getInt("COUNT"),
							rs.getString("SUMMARY"), rs.getInt("HIT"), rs.getDate("DATE"));
					return bookDTO;
				});
		return result;
	}

	public List<BookDTO> hitBook() {
		List<BookDTO> result = jdbcTemplate.query("SELECT * FROM BOOK WHERE HIT >= 5 ORDER BY HIT DESC;",
				(rs, rowNum) -> {
					BookDTO bookDTO = new BookDTO(rs.getString("ISBN"), rs.getString("TITLE"), rs.getString("AUTHOR"),
							rs.getString("GENRE"), rs.getString("PUBLISHER"), rs.getString("IMAGE"), rs.getInt("COUNT"),
							rs.getString("SUMMARY"), rs.getInt("HIT"), rs.getDate("DATE"));
					return bookDTO;
				});
		return result;
	}
	
	
}
