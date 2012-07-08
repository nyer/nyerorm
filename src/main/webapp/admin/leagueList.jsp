<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>联赛列表</title>
<%@ include file="../util.jsp" %>
</head>
<body>
	<table class="table">
		<tr class="tableTitle">
			<td>序号</td>
			<td>描述</td>
			<td>开始时间</td>
			<td>结束时间</td>
			<td>编辑</td>
			<td>删除</td>
		</tr>
		<s:iterator value="#request.leagues" id="league" status="index">
			<tr>
				<td>${index.index +1}</td>
				<td>
				 <s:url action="listRace" id="listRace">
					<s:param name="leagueId">${league.idLeague }</s:param>
				</s:url>
				 <a href="${listRace }">${league.desc }</a>
				</td>
				<td><s:date name="%{#league.start}" format="yyyy-MM-dd HH:mm" />
				<td><s:date name="#league.end" format="yyyy-MM-dd HH:mm" />
				<s:url action="editLeagueForm" id="edit">
					<s:param name="leagueId">${league.idLeague }</s:param>
				</s:url>
				<td><a href="${edit}">编辑</a>
				<td><a href="${path }/admin/deleteLeague.do?leagueId=${league.idLeague }">删除</a>
			</tr>
		</s:iterator>
	</table>
</body>
</html>