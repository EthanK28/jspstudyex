package ch10;

import java.util.*;
import java.sql.*;
import ch10.RegisterBean;

public class CopyOfRegisterMgrPool {
	private final String JDBC_DRIVER = "org.gjt.mm.mysql.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/mydb";
	private final String USER = "spring";
	private final String PASS = "book";
	private DBConnectionMgr pool = null;
	
	public CopyOfRegisterMgrPool() {
		try {
			pool = DBConnectionMgr.getInstance();
			
		} catch (Exception e) {
			System.out.println("Error : JDBC 드라이버 로딩 실패");
		}
	}
	
	public Vector getMemberList() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Vector vecList = new Vector();
		
		try {
			conn = pool.getConnection();
			String strQuery = "select * from tblRegister";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(strQuery);
			
			while(rs.next()){
				RegisterBean regBean = new RegisterBean();
				regBean.setId(rs.getString("id"));
				regBean.setPasswd(rs.getString("passwd"));
				regBean.setName(rs.getString("name"));
				regBean.setNum1(rs.getString("num1"));
				regBean.setNum2(rs.getString("num2"));
				regBean.setEmail(rs.getString("email"));
				regBean.setPhone(rs.getString("phone"));
				regBean.setAddress(rs.getString("address"));
				regBean.setJob(rs.getString("job"));
				vecList.add(regBean);
			}
			
			
		} catch (Exception ex) {
			System.out.println("Exception" +ex);
		} finally {
			pool.freeConnection(conn);
		}
			
		return vecList;
	}
	
}
