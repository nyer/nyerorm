<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../util.jsp" %>
<title>后台管理</title>
</head>

<frameset rows="60,*,0" cols="*" frameborder="no" frameborder="1" framespacing="0" onunload="closeWin()">
  <frame src="<%=request.getContextPath()%>/admin/top.jsp" name="topFrame" noresize="noresize"  scrolling="no" frameborder="0" id="topFrame" title="topFrame" framespacing="0" />
  <frameset name="mainSet" rows="*" cols="190,8,*" framespacing="0" scrolling="no"  frameborder="0">
    <frame src="<%=request.getContextPath()%>/admin/menu.jsp" name="leftFrame"  scrolling="yes" noresize="noresize" id="leftFrame" title="leftFrame" framespacing="0" />
    <frame src="<%=request.getContextPath()%>/admin/visiblemenu.jsp" name="menuFrame" scrolling="no" noresize="noresize" id="menuFrame" title="menuFrame" framespacing="0" />
    <frame src="<%=request.getContextPath()%>/admin/listLeague.do" name="mainFrame" id="mainFrame" title="mainFrame" framespacing="0" />
  </frameset>
  <frame src="<%=request.getContextPath()%>/admin/copyright.jsp" name="bottomFrame" noresize="noresize"  scrolling="no" frameborder="0" id="topFrame" title="bottomFrame" framespacing="0" />
</frameset>
<noframes>
<body>
</body>
</noframes>
</html>