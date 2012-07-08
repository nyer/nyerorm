<#include "template_common.ftl"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
</head>
<body>
	<center>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<h1>足球比赛竞猜系统</h1>
	<div class="container">
		<div class="main">
			<div class="w-m">
			<s:form action="login" method="post" onsubmit="return validate();" >
				<table>
					<tr>
						<td>用户名:</td>
						<td><input type="text" title="用户名" name="user.userName"/>
					</tr>
					<tr>
						<td>密码:</td>
						<td><input type="password" title="密码" name="user.password"/>
					</tr>
				</table>
				<input type="submit" value="登陆"/>
				<input type="button" value="注册" onclick="window.location.href='${path}/regForm.do'"/>
			</s:form>
			</div>
		</div>
	</div>
	</center>
	<link rel="stylesheet" href="${path }/js/datepicker/css/jquery-ui/smoothness/jquery-ui-1.8.18.custom.css">
<script type="text/javascript" src="${path}/js/jquery-1.6.1.js"></script>
  <script src="${path }/js/datepicker/js/libs/jquery-ui-1.8.18.custom.min.js"></script>
<link href="${path }/css/core.css" rel="stylesheet" >
	<script type="text/javascript">
		function validate(){
			var msg = '';
			var illegal = true;
			$('table input').each(function(){
				if($.trim(this.value) == ''){
					illegal = false;
					msg = this.title + '不能为空';
				}
				return illegal;
			});
			if(!illegal){
				alert(msg);
			}
			return illegal;
		}
	</script>
</body>
</html>