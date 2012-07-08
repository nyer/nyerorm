<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>比分</title>
<%@include file="../util.jsp" %>
</head>
<body>
<s:form action="scoreRace" method="post" onsubmit="return validate();">
	<table >
		<tr>
			<td colspan="2">${race.team1 }-${race.team2 }</td>
		</tr>
		<tr>
			<td><input type="text" name="race.team1Score" style="width:20px" title="分数"/>-</td>
			<td><input type="text" name="race.team2Score" style="width:20px" title="分数"/></td>
		</tr>
	</table>
	<input type="hidden" name="race.idRace" value="${race.idRace }"/>
	<input type="submit" value="提交"/>
</s:form>
<script type="text/javascript">
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