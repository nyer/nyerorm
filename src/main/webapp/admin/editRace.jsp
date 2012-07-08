<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑赛次</title>
<%@include file="../util.jsp" %>
</head>
<body>
<s:form action="editRace" method="post">
<table>
	<tr>
		<td>双方</td>
		<td colspan="2">
		<input type="text" name="race.team1" title="比赛方" value="${race.team1 }" />VS
		<input type="text" name="race.team2" title="比赛方" value="${race.team2 }"/>
	</tr>
	<tr>
		<td>开始时间</td>
		<td><input type="text" name="race.start" id="start" title="开始时间" value="${race.start }" /></td>
	</tr>
	<tr>
		<td>默认竞猜</td>
		<td>
		<select name="race.autoguess" title="默认竞猜">
			<option value="1" ${race.autoguess == 1?'selected':'' }>胜</option>
			<option value="0"  ${race.autoguess == 0?'selected':'' }>平</option>
			<option value="-1"  ${race.autoguess == -1?'selected':'' }>负</option>
		</select>
	</tr>
	<tr>
		<td>胜得分</td>
		<td><input type="text" name="race.winpoint"   title="胜得分" value="${race.winpoint }"/></td>
	</tr>
	<tr>
		<td>平得分</td>
		<td><input type="text" name="race.pinpoint"   title="平得分" value="${race.pinpoint }"/></td>
	</tr>
	<tr>
		<td>负得分</td>
		<td><input type="text" name="race.lostpoint"   title="负得分" value="${race.lostpoint }"/></td>
	</tr>
	<tr>
		<td>折扣</td>
		<td><input type="text" name="race.free" title="折扣" value="${race.free }"/></td>
	</tr>
</table>
<input type="hidden" name="race.idRace" value="${race.idRace}"/>
<input type="hidden" name="race.league" value="${race.league}"/>
<input type="submit" value="提交"/>
</s:form>
<script type="text/javascript">
	$(function(){
		$('#start,#end').datetimepicker(window.timeconfig);
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