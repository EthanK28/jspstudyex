package ch14;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;



public class BoardMgr {
	private DBConnectionMgr pool;
	private static final String SAVEFOLDER = "C:/dev/JEEworkspace/myapp/WebContent/ch14/fileupload";
	private static final String ENCTYPE = "UTF-8";
	private static int MAXSIZE = 5*1024*1024;
	
	public BoardMgr() {
		try {
			pool = DBConnectionMgr.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//게시판 리스트
	public Vector<BoardBean> getBoardList(String keyField, String keyWord, int start, int end){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<BoardBean> vlist = new Vector<BoardBean>();
		try {
			con = pool.getConnection();
			if(keyWord.equals("null") || keyWord.equals("")){
				sql = "select * from tblBoard order by ref desc, pos limit ?, ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			} else {
				sql = "select * from tblBoard where "+keyField+"like ?";
				sql += "order by ref desc, post limit ?, ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+keyWord+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			}
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				BoardBean bean = new BoardBean();
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setSubject(rs.getString("subject"));
				bean.setPos(rs.getInt("pos"));
				bean.setRef(rs.getInt("ref"));
				bean.setDepth(rs.getInt("depth"));
				bean.setRegdate(rs.getString("regdate"));
				bean.setCount(rs.getInt("count"));
				vlist.add(bean);			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;		
	}
	
	// 총 게시물 수 
	public int getTotalCount(String keyField, String keyWord){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int totalCount = 0;
		try {
			con = pool.getConnection();
			if(keyWord.equals("null")||keyWord.equals("")){
				sql = "select count(num) from tlBoard";
				pstmt  =
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return 0;
	}
}


