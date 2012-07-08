<#include "template.ftl"/>
<@page _pageTitle="联赛详情">
	<table class="table">
					<tr class="tableTitle">
					<td>序号</td>
					<td>比赛双方</td>
					<td>开始时间</td>
				</tr>
				<#list races as race>
				<tr>
					<td>${race_index +1 }</td>
					<td>
					<a href="${path }/raceRank.do?raceId=${race.idRace}">
					${race.team1 }VS${race.team2 }
					</a></td>
					<td>${race.start?string("yyyy-MM-dd HH:mm")}</td>
				</tr>
				</#list>
				</table>
</@page>
