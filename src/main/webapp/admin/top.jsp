<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../util.jsp" %>
</head>
<body>
<div style="position:absolute;left:30px;top:20px;">
足球比分竞猜后台管理系统
<div style="float:right;left:300px;top:25px;">
你好，${sessionAdmin.userName},<a href="${path }/admin/adminLogout.do" target="_top">退出</a>
</div>
</div>
</body>
</html>