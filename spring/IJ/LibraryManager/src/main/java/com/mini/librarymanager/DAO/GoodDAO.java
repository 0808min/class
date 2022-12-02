package com.mini.librarymanager.DAO;

import com.mini.librarymanager.DTO.*;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;

import javax.sql.*;
import java.util.*;

@Component
public class GoodDAO {
	private GoodDTO goodDTO;
	private JdbcTemplate jdbcTemplate;

	public GoodDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public GoodDTO selectByID(int inputID) {
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM GOOD WHERE ID=?;",
					(rs, rowNum) -> new GoodDTO(rs.getInt("ID"), rs.getString("ISBN"), rs.getString("TITLE"),
							rs.getString("CONTENT"), rs.getDate("DATE")),
					inputID);
		} catch (Exception ex) {
			return null;
		}
	}

	public GoodDTO showDetail(int inputID) {
		try {
			GoodDTO goodResult = jdbcTemplate.queryForObject("SELECT * FROM GOOD WHERE ID=?;",
					(rs, rowNum) -> new GoodDTO(rs.getInt("ID"), rs.getString("ISBN"), rs.getString("TITLE"),
							rs.getString("CONTENT"), rs.getDate("DATE")),
					inputID);

			BookDTO bookDTO = jdbcTemplate.queryForObject("SELECT * FROM BOOK WHERE ISBN=?;",
					(rs, rowNum) -> new BookDTO(rs.getString("ISBN"), rs.getString("TITLE"), rs.getString("AUTHOR"),
							rs.getString("GENRE"), rs.getString("PUBLISHER"), rs.getString("IMAGE"), rs.getInt("COUNT"),
							rs.getString("SUMMARY"), rs.getInt("HIT"), rs.getDate("DATE")),
					goodResult.getGoodISBN());

			return new GoodDTO(goodResult.getGoodID(), goodResult.getGoodISBN(), goodResult.getGoodTitle(),
					goodResult.getGoodContent(), bookDTO.getBookImage(), goodResult.getGoodDate());
		} catch (Exception ex) {
			return null;
		}
	}

	public List<GoodDTO> showAll() {
		List<GoodDTO> result = jdbcTemplate.query("SELECT * FROM GOOD;", (rs, rowNum) -> {
			GoodDTO goodDTO = new GoodDTO(rs.getInt("ID"), rs.getString("ISBN"), rs.getString("TITLE"),
					rs.getString("CONTENT"), rs.getDate("DATE"));
			return goodDTO;
		});
		return result;
	}

	public List<GoodDTO> showThree() {
		List<GoodDTO> goodResult = jdbcTemplate.query("SELECT * FROM GOOD ORDER BY ID DESC LIMIT 3;", (rs, rowNum) -> {
			GoodDTO goodDTO = new GoodDTO(rs.getInt("ID"), rs.getString("ISBN"), rs.getString("TITLE"),
					rs.getString("CONTENT"), rs.getDate("DATE"));
			return goodDTO;
		});

		List<GoodDTO> result = new ArrayList<GoodDTO>();

		for (GoodDTO goodDTO : goodResult) {
			BookDTO bookDTO = jdbcTemplate.queryForObject("SELECT * FROM BOOK WHERE ISBN=?;",
					(rs, rowNum) -> new BookDTO(rs.getString("ISBN"), rs.getString("TITLE"), rs.getString("AUTHOR"),
							rs.getString("GENRE"), rs.getString("PUBLISHER"), rs.getString("IMAGE"), rs.getInt("COUNT"),
							rs.getString("SUMMARY"), rs.getInt("HIT"), rs.getDate("DATE")),
					goodDTO.getGoodISBN());

			result.add(new GoodDTO(goodDTO.getGoodID(), goodDTO.getGoodISBN(), goodDTO.getGoodTitle(),
					goodDTO.getGoodContent(), bookDTO.getBookImage(), goodDTO.getGoodDate()));
		}

		return result;
	}

	public void insertGood(GoodDTO _goodDTO) {
		this.goodDTO = _goodDTO;

		jdbcTemplate.update("INSERT INTO GOOD(ISBN, TITLE, CONTENT, DATE) VALUES('" + goodDTO.getGoodISBN() + "', '"
				+ goodDTO.getGoodTitle() + "', '" + goodDTO.getGoodContent() + "', NOW());");
	}

	public void deleteGood(GoodDTO _goodDTO) {
		this.goodDTO = _goodDTO;

		jdbcTemplate.update("DELETE FROM GOOD WHERE ID=" + goodDTO.getGoodID() + ";");
	}
}
