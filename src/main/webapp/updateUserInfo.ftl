<#include "template.ftl"/>
<@page _pageTitle="信息更新">
<form action="${path}/updateUserInfo.do" method="post" onsubmit="return validate();" >
					<table>
						<tr>
							<td>用户名:</td>
							<td>${user.userName }</td>
						</tr>
						<tr>
							<td>邮箱:</td>
							<td><input type="text" id="email" name="user.email" title="邮箱" value="${user.email }" /></td>
						</tr>
						<tr>
							<td>密码:</td>
							<td><input type="password" id="password1" title="密码" name="user.password" value="${user.password }"/></td>
						</tr>
						<tr>
							<td>重复密码:</td>
							<td><input type="password" id="password2" title="重复密码"/></td>
						</tr>
					</table>
					<input type="submit" value="提交"/>
				</form>
</@page>
