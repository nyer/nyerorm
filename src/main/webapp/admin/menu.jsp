<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	String path = request.getContextPath();
	request.setAttribute("path",path);
%>
</head>
<body>
<ul>
	<li><a href="${path }/admin/listLeague.do" target="mainFrame">查看联赛</a></li>
	<li><a href="${path }/admin/addLeagueForm.do" target="mainFrame">添加联赛</a></li>
</ul>
</body>
</html>