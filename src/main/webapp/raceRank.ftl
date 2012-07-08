<#include "template.ftl"/>
<@page _pageTitle="赛次排名">
<table class="table">
				<tr class="tableTitle">
					<td>排名</td>
					<td>姓名</td>
					<td>竞猜</td>
					<td>得分</td>
					<td>默认</td>
				</tr>
				<#list joinedRaces as joinedRace>
				<tr>
				<td>${joinedRace_index +1 }</td>
				<td>${joinedRace.user.userName }</td>
				<td>
				<#if joinedRace.guess??>
				<#if joinedRace.guess == "1">
				胜
				<#else>
				负
				</#if>
				<#else>
				负
				</#if>
				</td>
				<td>
				${joinedRace.point!0 }
				</td>
				<td>
				<#if joinedRace.auto == 1>
				<font color="blue">是</font>
				<#else>
				否
				</#if>
				</td>
				</tr>
				</#list>
				</s:iterator>
				</table>
</@page>
