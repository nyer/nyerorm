<#include "template_common.ftl"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
	<center>
	<form action="${path}/reg.do" method="post" onsubmit="return validate();">
	<table>
		<tr>
			<td>用户名:</td>
			<td><input name="user.userName" title="用户名" id="userName"/></td>
		</tr>
		<tr>
			<td>邮箱:</td>
			<td><input name="user.email" title="邮箱" id="email"/></td>
		</tr>
		<tr>
			<td>密码:</td>
			<td><input type="password" name="user.password" id="password1"/></td>
		</tr>
		<tr>  
			<td>重复密码:</td>
			<td><input type="password" id="password2"/></td>
		</tr>
	</table>
	<input type="submit"/>
	</form>
	</center>
	<link rel="stylesheet" href="${path }/js/datepicker/css/jquery-ui/smoothness/jquery-ui-1.8.18.custom.css">
<script type="text/javascript" src="${path}/js/jquery-1.6.1.js"></script>
  <script src="${path }/js/datepicker/js/libs/jquery-ui-1.8.18.custom.min.js"></script>
<link href="${path }/css/core.css" rel="stylesheet" >
	<script type="text/javascript" >
	function validate(){
		var msg = '';
		var illegal = true;
		var pwd1 = '';
		$('table input').each(function(){
			if($.trim(this.value) == ''){
				illegal = false;
				msg = this.title + '不能为空';
			}else{
				if(this.id == 'password1'){
					pwd1 = this.value;
				}else if(this.id == 'password2'){
					if(this.value != pwd1){
						illegal = false;
						msg = '再次输入的密码不同';
					}
				}
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