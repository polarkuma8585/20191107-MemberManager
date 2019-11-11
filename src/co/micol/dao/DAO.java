/**
 * 
 */
package co.micol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @author 정재흠 작성일자 : 2019-11-07 상위 dao 객체
 */
public class DAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds; //커넥션 pool 사용을 위한 데이터 연결 생성 객체
	
//	private String driver = "oracle.jdbc.driver.OracleDriver";
//	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	private String user = "jaeheum";
//	private String pw = "jaeheum";

	public DAO() {
//		try {
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, user, pw);
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
		// connection pool 이용
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
			   
		} catch (NamingException |SQLException e) {
			e.printStackTrace();
		}
	

	}
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

