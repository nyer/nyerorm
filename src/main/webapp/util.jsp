<%@ page language="java" contentType="text/html; charset=UTF-8" import="org.nyer.copyright.guessfb.util.*"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>  

<%
	String path = request.getContextPath();
	request.setAttribute("path",path);
%>
<link rel="stylesheet" href="${path }/js/datepicker/css/jquery-ui/smoothness/jquery-ui-1.8.18.custom.css">
<script type="text/javascript" src="${path}/js/jquery-1.6.1.js"></script>
  <script src="${path }/js/datepicker/js/libs/jquery-ui-1.8.18.custom.min.js"></script>
<link href="${path }/css/core.css" rel="stylesheet" >
<script type="text/javascript">
			$(function(){
				window.timeconfig = {
						 showSecond: true,
						    timeFormat: 'hh:mm:ss',
						
						    closeText: '确定',
						    currentText: '现在',
						    timeText: '时间',
						    hourText: '小时',
						    minuteText: '分钟',
						    secondText: '秒'
					  	};
			});
		</script>