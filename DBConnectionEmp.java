package com.momo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionEmp {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "TESTUSER";
		String pw = "1234";

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		/*
		 * 1. 드라이버 로딩 DB에 접근하기 위해 필요한 라이브러리가 있는지 확인
		 * 
		 * 2. 커넥션 객체를 생성
		 * 
		 */
		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. 커넥션 생성
			con = DriverManager.getConnection(url, id, pw);

			// 3. 쿼리문장 준비
			String sql = "select emp_id, emp_name, emp_no from employee";

			// 4. 쿼리 문장 실행
			stmt = con.createStatement();
			
			// stmt.executeQuery(sql)
			// select문장을 실행할 경우  ResultSet을 반환합니다.
			// stmt.executeUpdate(sql)
			// update, insert, delete 의 경우 int 타입을 반환합니다.
			//     -> 실행결과 몇 건이 처리되었는지
			rs = stmt.executeQuery(sql);
			
			
			
			while(rs.next()) {
				// 숫자를 입력시 1부터
				// 숫자또는 결과집합의 컬럼명
				String empId = rs.getString("emp_id");
				String empName = rs.getString("emp_name");
				String empNo = rs.getString("emp_no");
					
			
			System.out.println("emp_id" + empId + 
					           ", emp_name: " + empName + 
					           ", emp_no: " + empNo);
		    }
			//System.out.println(rs.getString("1"));


		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩실패 - 라이브러리를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Connection 객체 생성 실패");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println("자원 해제중 예외사항이 발생하였습니다.");
				e.printStackTrace();
			}
		}

	}

}
