package com.mini.librarymanager.DAO;

import javax.sql.*;
import java.util.*;

import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;

import com.mini.librarymanager.DTO.*;

@Component
public class HopeDAO {
	private HopeDTO hopeDTO;
	private JdbcTemplate jdbcTemplate;

	public HopeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<HopeDTO> showAll() {
		List<HopeDTO> result = jdbcTemplate.query("SELECT * FROM REQUEST;", (rs, rowNum) -> {
			HopeDTO hopeDTO = new HopeDTO(rs.getString("ISBN"), rs.getString("TITLE"), rs.getInt("NUMBER"),
					rs.getString("LINK"));
			return hopeDTO;
		});
		return result;
	}

	public HopeDTO selectByISBN(String inputISBN) {
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM REQUEST WHERE ISBN=?;",
					(rs, rowNum) -> new HopeDTO(rs.getString("ISBN"), rs.getString("TITLE"), rs.getInt("NUMBER"),
							rs.getString("LINK")),
					inputISBN);
		} catch (Exception ex) {
			return null;
		}
	}

	public void insertHope(HopeDTO _hopeDTO) {
		this.hopeDTO = _hopeDTO;

		jdbcTemplate.update("INSERT INTO REQUEST(ISBN, TITLE, NUMBER, LINK) VALUES('" + hopeDTO.getHopeISBN() + "', '"
				+ hopeDTO.getHopeTitle() + "', " + hopeDTO.getHopeNumber() + ", '" + hopeDTO.getHopeLink() + "');");
	}

	public void updateHope(HopeDTO _hopeDTO) {
		this.hopeDTO = _hopeDTO;

		jdbcTemplate.update("UPDATE REQUEST SET NUMBER=NUMBER+1 WHERE ISBN=" + hopeDTO.getHopeISBN() + ";");
	}

}
