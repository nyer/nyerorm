<#include "template_common.ftl"/>
<#macro page _pageTitle=""  _pageDesc="">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="${_pageDesc}"/>
<title>${_pageTitle}</title>
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
</head>
<body>
	<div class="container">
		<div class="header">
			<div class="w-h">
				<div class="nav">
					<ul>
						<li <#if _pageTitle="正在参加的联赛">class="selected"</#if>><a href="${path }/homePage.do">正在参加的联赛</a></li>
						<li <#if _pageTitle="参加联赛">class="selected"</#if>><a href="${path }/listUnaddedLeague.do">参加联赛</a></li>
						<li <#if _pageTitle="已结束的联赛">class="selected"</#if>><a href="${path }/listEndedLeague.do">已结束的联赛</a></li>
					</ul>
				</div>
				<div class="userAct">
					<a class="out" href="${path }/logout.do">退出</a>
					<span class="sep">|</span>
					<a class="name" href="${path }/viewInfo.do">${sessionUser.userName}</a>
				</div>
			</div>
		</div>
		<div class="main">
			<div class="w-m">
				<#nested/>
			</div>
		</div>
		<div class="footer">
			<div class="w-f">
				<div class="copyright"></div>
			</div>
		</div>
	</div>
	
</body>
</html>
</#macro>