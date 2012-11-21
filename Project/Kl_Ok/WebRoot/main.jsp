<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	response.setCharacterEncoding("utf-8");
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>卡拉ok点歌</title>
<style>
<!--
.div {
	width: 650;
	height: 4%;
	padding-top: 8px;
	line-height: 15px;
	font-size: 20px;
	padding-bottom: 5px;
}
.p1{
	width: 650;
	height: 4%;
	font-size: 16px;
	text-align: center;
}
.body{
	background-image:url(image/b113.gif);
	background-repeat:repeat;
}
-->
</style>
<script type="text/javascript">
	var lytext = new Array();//放存汉字的歌词
	var lytime = new Array();//存放时间
	function show(t)//显示歌词
	{
		var div1 = document.getElementById("lyr");//取得层
		div1.innerHTML = " ";//每次调用清空以前的一次
		if (t < jwplayer("mediaplayer").getDuration())//先舍弃数组的最后一个
		{
			for ( var k = 0; k < lytext.length; k++) {
				if (lytime[k] <= t && t < lytime[k + 1]) {
					if(k%2 == 0){
					div1.innerHTML = "<p align='left'><font color=red style=font-weight:bold>"+ lytext[k] + "</font></p>";
					div1.innerHTML += "<p align='right'><font color=black>"+ lytext[k+1] + "</font></p>";
					}else
					{
					div1.innerHTML = "<p align='left'><font color=black>"+ lytext[k+1] + "</font></p>";
					div1.innerHTML += "<p align='right'><font color=red style=font-weight:bold>"+ lytext[k] + "</font></p>";
					}
					break;
				}
			}
		} 
	}
	function getReady()//在显示歌词前做好准备工作
	{
		lytext = ${lrcinfo.lrc };
		lytime = ${lrcinfo.time };
	}

	function mPlay()//开始播放
	{
		var ms = jwplayer("mediaplayer").getPosition();
		show(ms);
		window.setTimeout("mPlay()", 500);
	}

	window.setTimeout("mPlay()", 500);
</script>
</head>
<body  class="body" onload="getReady()">
<jsp:include page="head.jsp"></jsp:include>
	<table width="80%" height="60%" border="0" align="center">
	<tr>
	<td align="center"><div class="p1"><b>当前播放曲目：</b>${music.mname } <b>歌手：</b>${music.mart } <b>专辑：</b>${music.maum } </div></td>
	</tr>
		<tr>
			<td height="60%" align="center">
				<div id="mediaplayer">正在加载...</div> 
				<script type="text/javascript" src="js/jwplayer.js"></script> 
				<script type="text/javascript">
						jwplayer("mediaplayer").setup({
							flashplayer : "js/player.swf",
							height : 390,
							width : 700,
							file : "${music.mfa }",
							autostart : true ,
							image: "preview.jpg"
						});
					</script>
				</td>
		</tr>
		<tr>
			<td height="4%" align="center">
				<div id=lyr class=div>歌词加载中……</div></td>
		</tr>
	</table>
</body>
</html>
