package potato.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import potato.domain.Board;
import potato.domain.Session;


public class BoardDao {

	
	// 게시물 작성
	public int insert(Connection conn, Board board) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;


		String sql = "insert into potato_board (boardid, userid, category, product, saleprice, tradeloc) values (?, ?, ?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getBoardid()); 
			pstmt.setString(2, board.getUserid()); 
			pstmt.setInt(3, board.getCategory());
			pstmt.setString(4, board.getProduct());
			pstmt.setInt(5, board.getSaleprice()); 
			pstmt.setString(6, board.getTradeloc());


			result = pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;
	}

	
	// 게시물 수정
	public int update(Connection conn, Board board) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "update potato_board set category=?, product=?, saleprice=?, tradeloc=? where boardid=? and userid=? and salestatus=1";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getCategory());
			pstmt.setString(2, board.getProduct());
			pstmt.setInt(3, board.getSaleprice());
			pstmt.setString(4, board.getTradeloc());
			pstmt.setInt(5, board.getBoardid());
			pstmt.setString(6, Session.getInstance().getLoginData().getId()); // id 불러오기

			result = pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;
	}

	
	// 게시물 삭제
	public int delete(Connection conn,  Board board) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "delete from potato_board where boardid=? and userid=? and salestatus=1";
		// salestatus = 1 -> 판매상태 true, 즉 판매중일 때 삭제 가능
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getBoardid());
			pstmt.setString(2, board.getUserid());
	
			result = pstmt.executeUpdate();
			
		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
		}

		return result;
	}

	
// -----------------------------------------
	
	// DB에 저장된 판매 게시글 불러오기
	public List<Board> select(Connection conn) throws SQLException {
		
		List<Board> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			
			String sql = "Select * from potato_board"; // 쿼리문 문자열로 변환
			rs = stmt.executeQuery(sql); // ResultSet 객체 반환
			

			while (rs.next()) {
				list.add(rowToBoard(rs));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				rs.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
		}
		
		return list;
		
	}
	
	
	// 행 단위로 데이터 입력해주는 메소드
	private Board rowToBoard(ResultSet rs) throws SQLException {
		return new Board(rs.getInt("boardid"), rs.getString("userid"), rs.getInt("category"), 
				rs.getString("product"), rs.getInt("saleprice"), rs.getBoolean("salestatus"),
				rs.getInt("writedate"), rs.getString("tradeloc"));
	}


}