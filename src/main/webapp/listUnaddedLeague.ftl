<#include "template.ftl"/>
<@page _pageTitle="参加联赛">
<table class="table">
					<tr class="tableTitle">
						<td>序号</td>
						<td>描述</td>
						<td>开始时间</td>
						<td>结束时间</td>
						<td>查看排名</td>
						<td>操作</td>
					</tr>
					<#list leagues as league>
					<tr>
						<td>${league_index  +1}</td>
						<td><a href="${path }/viewUnaddedLeague.do?leagueId=${league.idLeague}">${league.desc }</a></td>
						<td>${(league.start)?string("yyyy-MM-dd HH:mm")}</td>
						<td>${(league.end)?string("yyyy-MM-dd HH:mm")}</td>
						<td>
							<#if league.started>
							<a href="${path }/viewRank.do?leagueId=${league.idLeague }">查看</a>
							</#if>
						</td>
						<td><a href="${path }/attendLeague.do?leagueId=${league.idLeague}">参加</a></td>
					</tr>
					</#list>
				</table>
</@page>
