<%@ page contentType="text/html; charset=UTF-8" %>
<html>
	<haed></haed>
	<%@page import="java.util.Vector" %>
	<%-- <jsp:useBean id="bMgr" class="ch14.BoardMgr"></jsp:useBean> --%>
	

<%
	request.setCharacterEncoding("UTF-8");
	int totalRecord = 0;
	int numPerPage = 10;
	int pagePerBlock = 15;
	
	int totalPage = 0;
	int totalBlock = 0;
	
	int nowPage = 1;
	int nowBlock = 1;
	
	int start = 0;
	int end = 10;
	
	int listSize = 0; // 현재 읽어온 게시물의 수
	
	String keyWord = "", keyField = "";
	Vector<BoardBean> vlist = null;
	if(request.getParameter("keyWord")!=null){
		keyWord = request.getParameter("keyWord");
		keyField = request.getParameter("keyField");
	}
	
	
%>
	
</html>