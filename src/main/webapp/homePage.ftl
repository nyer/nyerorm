<#include "template.ftl"/>
<@page _pageTitle="正在参加的联赛" _pageDesc="">
	<table class="table">
					<tr class="tableTitle">
						<td>序号</td>
						<td>描述</td>
						<td>开始时间</td>
						<td>结束时间</td>
						<td>得分</td>
						<td>查看排名</td>
					</tr>
					<#list joinedLeagues as joinedLeague>
					<#assign league=joinedLeague.getLeague()/>
					<tr>
						<td>${joinedLeague_index  +1}</td>
						<td><a href="${path }/viewLeagueDetail.do?joinedLeagueId=${joinedLeague.idJoinedLeague}">${league.desc }</a></td>
						<td>${(league.start)?string("yyyy-MM-dd HH:mm")}</td>
						<td>${(league.end)?string("yyyy-MM-dd HH:mm")}</td>
						<td>${joinedLeague.score }</td>
						<td><a href="${path }/viewRank.do?leagueId=${league.idLeague }">查看</a></td>
					</tr>
					</#list>
				</table>
</@page>
