<#include "template.ftl"/>
<@page _pageTitle="联赛详细" _pageDesc="">
<table class="table">
					<tr class="tableTitle">
					<td>序号</td>
					<td>比赛双方</td>
					<td>开始时间</td>
					<td>比分</td>
					<td>竞猜</td>
					<td>得分</td>
					<td>默认</td>
				</tr>
				<#list races as race>
				<tr>
					<td>${race_index + 1}</td>
					<td>
					<a href="${path }/raceRank.do?raceId=${race.idRace}">
					${race.team1 }VS${race.team2 }
					</a></td>
					<td>${(race.start)?string("yyyy-MM-dd HH:mm")}</td>
					<td>${race.team1Score! }-${race.team2Score! }</td>
					<td>
					<#if race.guess??>
						<#if race.guess == "0" >
						平
						<#elseif race.guess == "1">
						胜
						<#elseif race.guess == "-1">
						负
						</#if>
					<#else>
						<#if race.canGuess>
								<#if readonly??>
								<#else>
								<a href="${path }/guessRaceForm.do?raceId=${race.idRace}"  >竞猜</a>
								</#if>
						<#else>
							<font color="red">时间已过</font>
						</#if>
					</#if>
					</td>
					<td>${race.point!0}</td>
					<td>
					<#if race.auto!?string == "1">
					是
					<#else>
					否
					</#if>
					</td>
				</tr>
				</#list>
				</table>
</@page>
