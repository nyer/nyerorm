<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<%@ include file="../util.jsp" %>
</head>
<body>
	<s:form action="editLeague" method="post" onsubmit="return validate();">
	<input type="hidden" name="league.idLeague" value="${league.idLeague }"/>
	<table>
		<tr>
			<td>描述:</td>
			<td><input type="text" name="league.desc" value="${league.desc }" title="描述"/>
		</tr>
		<tr>
			<td>开始时间:</td>
			<s:date name="#request.league.start" format="yyyy-MM-dd HH:mm:ss" id="start"/>
			<td><input type="text" name="league.start" id="starttime" value="${start }" title="开始时间"/>
		</tr>
		<tr>
			<td>结束时间:</td>
			<s:date name="#request.league.end" format="yyyy-MM-dd HH:mm:ss" id="end"/>
			<td><input type="text" name="league.end" id="endtime" value="${end }" title="结束时间"/>
		</td>
	</table>
	<input type="submit" value="提交"/>
	</s:form>
		<script type="text/javascript">
			$(function(){
				$('#starttime').datetimepicker(window.timeconfig);
				$('#endtime').datetimepicker(window.timeconfig);
			});
			function validate(){
				var illegal = true;
				var msg = '';
				$("form input").each(function(){
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