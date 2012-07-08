<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>注册</title>
<%@include file="../util.jsp" %>
</head>
<body>
	<s:form action="addLeague" method="post" onsubmit="return validate();" >
	<table>
		<tr>
			<td>描述:</td>
			<td><input name="league.desc" title="描述"/></td>
		</tr>
		<tr>
			<td>开始时间:</td>
			<td><input name="league.start" id="start" title="开始时间 "/></td>
		</tr>
		<tr>
			<td>结束时间:</td>
			<td><input type="text" name="league.end" id="end" title="结束时间"/></td>
		</tr>
	</table>
	<input type="submit" value="提交"/>
	</s:form>
	<script type="text/javascript">
		$(function(){
			$('#start,#end').datetimepicker(window.timeconfig)
		});
		function validate(){
			var illegal = true;
			var msg = '';
			$("table  input").each(function(){
				if($.trim(this.value) == ''){
					illegal = false;
					msg = this.title + "不能为空";
				}
				return illegal;
			})
			if(!illegal){
				alert(msg)
			}
			return illegal;
		}
	</script>
</body>
</html>