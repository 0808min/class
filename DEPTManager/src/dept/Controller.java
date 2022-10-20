package dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Controller {

//	기능 클래스 
//	사용자 요청의 실제 처리 클래스 : 사용자에게 데이터를 받고 DB처리 결과 출력
	Scanner sc;

	public Controller() {
		sc = new Scanner(System.in);
	}

//	1. 전체 부서 리스트
	public void select() {
		try {

	
			Statement stmt = conn.createStatement();

			String sql = "select * from dept";
			ResultSet rs = stmt.executeQuery(sql);

			System.out.println("부서 리스트를 출력합니다");

			System.out.println("부서 리스트");
			System.out.println("----------------------------------------------------");
			System.out.printf("%8s %8s %9s \n", "부서번호", "부서이름", "위치");
			System.out.println("----------------------------------------------------");

			while (rs.next()) {
				int deptno = rs.getInt(1);
				String dname = rs.getString(2);
				String loc = rs.getString(3);

				System.out.printf("%10d  %10s  %10s \n", deptno, dname, loc);
			}

			System.out.println("----------------------------------------------------");

			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	2. 부서검색
	public void selectByDeptno() {

		System.out.println("검색할 부서번호를 입력해주세요. >> ");
		int no = Integer.parseInt(sc.nextLine());
		try {

			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			// String dbUrl = "jdbc:mysql://localhost:3306/project";
			Connection conn = DriverManager.getConnection(dbUrl, "scott", "tiger");
			String sql = "select * from dept where deptno=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 10);

			ResultSet rs = pstmt.executeQuery();

			System.out.println("검색 결과");
			System.out.println("----------------------------------------------------");

			if (rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");

				System.out.printf("%5d \t %10s \t %10s \n", deptno, dname, loc);
			} else {
				System.out.println("검색하신 번호의 부서는 존재하지 않습니다.");
			}

			System.out.println("----------------------------------------------------");

			rs.close();
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	3. 부서 정보 저장
	public void insert() {

		System.out.println("부서정보 입력을 시작합니다");

		System.out.println("부서번호 >> ");
		int deptno = Integer.parseInt(sc.nextLine());

		System.out.println("부서이름 >> ");
		String dname = sc.nextLine();

		System.out.println("위치 >> ");
		String loc = sc.nextLine();

		try {

			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			// String dbUrl = "jdbc:mysql://localhost:3306/project";
			Connection conn = DriverManager.getConnection(dbUrl, "scott", "tiger");
			String sql = "insert into dept values (?, ?, ?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("입력되었습니다.");
			}

			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	4. 부서 정보 수정
	public void update() {

		System.out.println("부서 정보 수정이 시작됩니다.");

		System.out.println("수정하실 부서번호를 입력해주세요 >> ");
		int deptno = Integer.parseInt(sc.nextLine());

		System.out.println("새로운 부서이름 >> ");
		String dname = sc.nextLine();

		System.out.println("새로운 부서위치 >> ");
		String loc = sc.nextLine();

		try {

			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			// String dbUrl = "jdbc:mysql://localhost:3306/project";
			Connection conn = DriverManager.getConnection(dbUrl, "scott", "tiger");
			String sql = "update dept set dname=?, loc=? where deptno=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);
			pstmt.setInt(3, deptno);

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("수정되었습니다.");
			}

			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	5. 부서 정보 삭제
	public void delete() {
		
		System.out.println("삭제가 진행됩니다.");
		
		System.out.println("삭제할 부서의 번호를 입력해주세요 >> ");
		int deptno = Integer.parseInt(sc.nextLine());
		
		

		try {

			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			// String dbUrl = "jdbc:mysql://localhost:3306/project";
			Connection conn = DriverManager.getConnection(dbUrl, "scott", "tiger");
			String sql = "delete from dept where deptno=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("삭제되었습니다.");
			}

			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	6. 종료
	public void exit() {
		
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
		
	}

}
