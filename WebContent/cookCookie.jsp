<%@ page contentType="text/html; charset=euc-kr" %>

<html>
	<head>
		<title>
			Cook Cookie
		</title>
	</head>
	<%
		String cookieName = "myCookie";
		Cookie cookie = new Cookie(cookieName, "Apple");
		cookie.setMaxAge(60);
		cookie.setValue("Melone");
		response.addCookie(cookie);
	%>
<body>
	<h1>Example Cookie</h1>
	<p>
		��Ű�� ����ϴ�<br>
		��Ű ������ <a href="tasteCookie.jsp">�����</a>!!!!��	</p>
</body>
</html>