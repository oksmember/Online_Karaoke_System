<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
.div
{
width:460px;
height:200px;
overflow-y:scroll;
padding-top:80px;
text-align:left;
padding-left:100px;
line-height:25px;
font-size:13px;
padding-bottom:50px;
}
-->
</style>
	<script type="text/javascript">
var lytext=new Array();//放存汉字的歌词
var lytime=new Array();//存放时间
var delay=10;
var scrollh=0;
var time1;
var time2;
function show(t)//显示歌词
{
var div1=document.getElementById("lyr");//取得层
document.getElementById("lyr").innerHTML=" ";//每次调用清空以前的一次
if(t<lytime[lytime.length-1])//先舍弃数组的最后一个
{
for(var k=0;k<lytext.length;k++)
{
if(lytime[k]<=t&&t<lytime[k+1])
{
scrollh=k*25;//让当前的滚动条的顶部改变一行的高度
div1.innerHTML+="<font color=red style=font-weight:bold>"+lytext[k]+"</font><br>";
}
else if(t<lytime[lytime.length-1])//数组的最后一个要舍弃
div1.innerHTML+=lytext[k]+"<br>";
}
}
else//加上数组的最后一个
{
for(var j=0;j<lytext.length-1;j++)
div1.innerHTML+=lytext[j]+"<br>";
div1.innerHTML+="<font color=red style=font-weight:bold>"+lytext[lytext.length-1]+"</font><br>";
}
}
function scrollBar()//设置滚动条的滚动
{
if(document.getElementById("lyr").scrollTop<=scrollh)
document.getElementById("lyr").scrollTop+=1;
if(document.getElementById("lyr").scrollTop>=scrollh+50)
document.getElementById("lyr").scrollTop-=1;
if(time2)
window.clearTimeout(time2);
window.setTimeout("scrollBar()",delay);
}
function getReady()//在显示歌词前做好准备工作
{
lytext=${lrcinfo.lrc};
lytime=${lrcinfo.time};
time2=window.setTimeout("scrollBar()",delay);
}

function mPlay()//开始播放
{
var ms=jwplayer("mediaplayer").getPosition();
if(isNaN(ms))
show(0);
else
show(ms);
if(time1)
window.clearTimeout(time1);
window.setTimeout("mPlay()",100);
}
time1=window.setTimeout("mPlay()",100);
</script>
</head>

<body onLoad="getReady()">
<table width="1018" height="647" border="1" align="center">
  <tr>
    <td height="400" align="center">
    <div id="mediaplayer">正在加载...</div>
	
	<script type="text/javascript" src="js/jwplayer.js"></script>
	<script type="text/javascript">
		jwplayer("mediaplayer").setup({
			flashplayer: "js/player.swf",
			height: 640,
			width: 800,
			file: "${music.mfa }",
			image: "preview.jpg"
		});
	</script>
    </td>
  </tr>
  <tr>
    <td height="230" align="center">
	<div id=lyr class=div>歌词加载中……</div>
</td>
  </tr>
</table>
</body>
</html>
