package dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Controller {
	
//	��� Ŭ���� 
//	����� ��û�� ���� ó�� Ŭ���� : ����ڿ��� �����͸� �ް� DBó�� ��� ���
	Scanner sc;
	
	public Controller() {
		sc = new Scanner(System.in);
	}
	
	
//	1. ��ü �μ� ����Ʈ
	public void select () {
		try {
			
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			// String dbUrl = "jdbc:mysql://localhost:3306/project";
			Connection conn = DriverManager.getConnection(dbUrl, "scott", "tiger");
			Statement stmt = conn.createStatement();
			
			String sql = "select * from dept";
			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.println("�μ� ����Ʈ�� ����մϴ�");
			
			System.out.println("�μ� ����Ʈ");
			System.out.println("----------------------------------------------------");
			System.out.printf("%8s %8s %9s \n", "�μ���ȣ", "�μ��̸�", "��ġ");
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
	
//	2. �μ��˻�
	public void selectByDeptno() {
		
		System.out.println("�˻��� �μ���ȣ�� �Է����ּ���. >> ");
		int no = Integer.parseInt(sc.nextLine());
		try {
			
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			// String dbUrl = "jdbc:mysql://localhost:3306/project";
			Connection conn = DriverManager.getConnection(dbUrl, "scott", "tiger");
			String sql = "select * from dept where deptno=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 10);

			ResultSet rs = pstmt.executeQuery();
			
			System.out.println("�˻� ���");
			System.out.println("----------------------------------------------------");

			if (rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");

				System.out.printf("%5d \t %10s \t %10s \n", deptno, dname, loc);
			} else {
				System.out.println("�˻��Ͻ� ��ȣ�� �μ��� �������� �ʽ��ϴ�.");
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
	
//	3. �μ� ���� ����
	public void insert() {
		
	}
	
//	4. �μ� ���� ����
	public void update() {
		
	}
	
//	5. �μ� ���� ����
	public void delete() {
		
	}
	
//	6. ����
	public void exit() {
		
	}

}
