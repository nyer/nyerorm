<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../util.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
    
    <title>My JSP 'visiblemenu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function visibleMenu(btn){
			var p = window.parent;
			var id=btn.id;
			if(id=="btn1"){
				btn.id="btn2";
				p.mainSet.cols="0,8,*";
			}else{
				btn.id="btn1";
				p.mainSet.cols="190,8,*";
			}
		}
		
		document.body.onload = function(){
			var iWidth = window.screen.availWidth;
		    var iHeight = window.screen.availHeight;
		    var top = (iHeight-400)/2;
			var btn = document.createElement("BUTTON");
			$(btn).attr("id","btn1");
			$(btn).css("position","absolute");
			$(btn).css("width","8");
			$(btn).css("height","60");
			$(btn).css("top",top);
			$(btn).css("left","0");
			document.body.appendChild(btn);
			$(btn).bind("click",function(){
				visibleMenu(btn);
			});
		}
	</script>
  </head>
  
  <body>
  </body>
</html>
