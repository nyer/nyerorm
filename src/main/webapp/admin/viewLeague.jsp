<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<%@ include file="../util.jsp" %>
</head>
<body>
	<s:form action="adminLogin" method="post">
	<table>
		<tr>
			<td>用户名:</td>
			<td><input type="text" name="user.userName"/>
		</tr>
		<tr>
			<td>密码:</td>
			<td><input type="password" name="user.password"/>
		</tr>
	</table>
	<input type="submit" value="登陆"/>
	</s:form>
</body>
</html>