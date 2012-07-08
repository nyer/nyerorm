<#include "template.ftl"/>
<@page _pageTitle="信息查看">
<table>
					<tr>
						<td>id:</td>
						<td>${user.id }</td>
					</tr>
					<tr>
						<td>用户名:</td>
						<td>${user.userName }</td>
					</tr>
					<tr>
						<td>邮箱:</td>
						<td>${user.email }</td>
					</tr>
					<tr>
						<td><input type="button" value="修改信息" onclick = "window.location = '${path}/updateUserInfoForm.do'"/>
					</tr>
				</table>
</@page>
