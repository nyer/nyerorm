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
	<center>
	<br/>
	<br/>
	<h1>足球比赛竞猜后台管理系统</h1>
	<div class="container">
		<div class="main">
			<div class="w-m">
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
			</div>
		</div>
	</div>
	</center>
</body>
</html>