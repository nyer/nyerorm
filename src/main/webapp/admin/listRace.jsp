<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>赛次列表</title>
<%@include file="../util.jsp" %>
</head>
<body>
<s:url action="addRaceForm" id="addRaceForm">
	<s:param name="leagueId">${league.idLeague }</s:param>
</s:url>
<a href="${addRaceForm }">添加赛次</a>
<table class="table">
	<tr class="tableTitle">
		<td>序号</td>
		<td>比赛双方</td>
		<td>开始时间</td>
		<td>比分</td>
		<td>默认竞猜</td>
		<td>羸得分</td>
		<td>平得分</td>
		<td>输得分</td>
		<td>打折</td>
		<td colspan=2">操作</td>
	</tr>
	<s:iterator value="#request.races" id="race" status="index">
		<tr>
			<td>${index.index +1 }</td>
			<td>${race.team1 }VS${race.team2 }</td>
			<td>
			<s:date name="#race.start"/>
			</td>
			<td>
			${race.team1Score }-${race.team2Score }
			</td>
			<td>
			<s:if test="#request.race.autoguess ==1">
			胜	
			</s:if>
			<s:elseif test="#request.race.autoguess == 0">
			平
			</s:elseif>
			<s:else>
			败
			</s:else>
			</td>
			<td>
			${race.winpoint }
			</td>
			<td>
			${race.pinpoint }
			</td>
			<td>
			${race.lostpoint }
			</td>
			<td>
			${race.free }
			</td>
			<td>
			<s:url action="editRaceForm" id="editRace">
				<s:param name="raceId">${race.idRace }</s:param>
			</s:url>
			<a href="${editRace }">编辑</a>
			</td>
			<td>
			<s:url action="deleteRace" id="deleteRace">
				<s:param name="raceId">${race.idRace }</s:param>
			</s:url>
			<a href="${deleteRace }">删除</a>
			<s:url action="scoreRaceForm" id="scoreRace">
				<s:param name="raceId">${race.idRace }</s:param>
			</s:url>
			<a href="${scoreRace }">比分</a>
			</td>
		</tr>
	</s:iterator>
</table>
</body>
</html>