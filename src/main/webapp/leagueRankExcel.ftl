<#include "template.ftl"/>
<@page _pageTitle="联赛排名查看" >
<table class="table">
					<tr class="tableTitle">
					<td>排名</td>
					<td>排名变化 </td>
					<td>姓名</td>
					<td>得分</td>
				</tr>
				<#list leagueRankItems as leagueRankItem>
				<#assign user=leagueRankItem.user/>
				<tr 
				>
					<td>${leagueRankItem_index +1}</td>
					<td>
					<#if leagueRankItem.change!?int == 1>
					上升
					<#elseif leagueRankItem.change!?int == -1>
					下降
					<#elseif  leagueRankItem.change!?int == 0>
					无变化
					</#if>
					</td>
					<td><a href="${path}/viewLeagueDetail.do?joinedLeagueId=${leagueRankItem.joinedLeagueId}">${user.userName }</a></td>
					<td>${leagueRankItem.score }</td>
				</tr>
				</#list>
				</table>
</@page>
