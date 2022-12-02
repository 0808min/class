package com.mini.librarymanager.DAO;

import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;
import java.util.*;
import javax.sql.*;

import com.mini.librarymanager.DTO.*;

@Component
public class PhraseDAO {
	private PhraseDTO phraseDTO;
	private JdbcTemplate jdbcTemplate;

	public PhraseDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public PhraseDTO selectOverDue() {
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM PHRASE WHERE ID=1;", (rs, rowNum) -> {
				new PhraseDTO(rs.getInt("ID"), rs.getString("PHRASE"));
				return phraseDTO;
			});
		} catch (Exception ex) {
			return null;
		}
	}

	public List<PhraseDTO> showAll() {
		List<PhraseDTO> result = jdbcTemplate.query("SELECT * FROM PHRASE ORDER BY RAND() LIMIT 1;", (rs, rowNum) -> {
			this.phraseDTO = new PhraseDTO(rs.getInt("ID"), rs.getString("PHRASE"));
			return phraseDTO;
		});
		return result;
	}
}
