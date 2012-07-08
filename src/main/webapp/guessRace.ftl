<#include "template.ftl"/>
<@page _pageTitle="竞猜">
<form action="${path}/guessRace.do" method="post">
	<table>
		<tr>
			<td>比赛双方:</td>
			<td>${race.team1 }&nbsp;&nbsp;VS${race.team2 }</td>
		</tr>
		<tr>
			<td>竞猜:</td>
			<td>
				<select name="guess">
					<option value="0" selected="selected">平</option>
					<option value="1">胜</option>
					<option value="-1">负</option>
				</select>
			</td>
		</tr>
	</table>
	<input type="hidden" name="raceId" value="${race.idRace }"/>
	<input type="submit" value="提交"/>
</form>
</@page>
