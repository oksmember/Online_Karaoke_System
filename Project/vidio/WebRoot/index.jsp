<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ page import="util.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
response.setCharacterEncoding("utf-8");
request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
<%
	LrcParser lrcparser=new LrcParser();
	LrcInfo lrc=lrcparser.parser(getServletContext().getRealPath( "/")+"a.lrc");
 %>
	<script type="text/javascript">
	function getTimes ()
{
	alert(jwplayer("mediaplayer").getDuration());
	alert(jwplayer("mediaplayer").getPosition());
}
var scrollt=0;
var tflag=0;					//存放时间和歌词的数组的下标
var lytext=new Array();//放存汉字的歌词
var lytime=new Array();//存放时间
var delay=10;
var line=0;
var scrollh=0;
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
window.setTimeout("scrollBar()",delay);
}
function getReady()//在显示歌词前做好准备工作
{
lytext=<%=lrc.getLrc()%>;
lytime=<%=lrc.getTime()%>;
scrollBar();
}
function conSeconds(t)//把形如：01：25的时间转化成秒；
{
var m=t.substring(0,t.indexOf(":"));
var s=t.substring(t.indexOf(":")+1);
s=parseInt(s.replace(/\b(0+)/gi,""));
if(isNaN(s))
s=0;
var totalt=parseInt(m)*60+s;
//alert(parseInt(s.replace(/\b(0+)/gi,"")));
if(isNaN(totalt))
return 0;
return totalt;
}
function getSeconds()//得到当前播放器播放位置的时间
{
var t=getPosition();
//alert(s);
return t;
}
function getPosition()//返回当前播放的时间位置
{
//var mmt=;
//alert(mmt);
return jwplayer("mediaplayer").getPosition();
}
function mPlay()//开始播放
{
var ms=parseInt(getSeconds());
if(isNaN(ms))
show(0);
else
show(ms);
window.setTimeout("mPlay()",100);
}
window.setTimeout("mPlay()",100);
function test()//测试使用，
{
alert(lytime[lytime.length-1]);
}
</script>
  </head>
  
  <body onLoad="getReady()">
    <%=basePath %>|||<%=path %>
<!-- START OF THE PLAYER EMBEDDING TO COPY-PASTE -->
	<div id="mediaplayer">JW Player goes here</div>
	
	<script type="text/javascript" src="jwplayer.js"></script>
	<script type="text/javascript">
		jwplayer("mediaplayer").setup({
			flashplayer: "player.swf",
			height: 640,
			width: 800,
			file: "a.mp4",
			image: "preview.jpg"
		});
	</script>
	<!-- END OF THE PLAYER EMBEDDING -->

<div id=lyr class=div>歌词加载中……</div>

<input type="button" value="当前时间" onclick="getTimes()"/>
  </body>
</html>

