<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>卡拉ok点歌</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
<frameset rows="*,3,1" cols="*,400" framespacing="1" frameborder="yes" border="1">
  <frameset rows="188,*" cols="*" framespacing="0" frameborder="no" border="0">
    <frame src="head.html" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" title="head" />
    <frame src="main.html" name="mainFrame" id="mainFrame" title="main" />
  </frameset>
  <frame src="welcome.jsp" name="rightFrame" scrolling="no" noresize="noresize" id="rightFrame" title="right" />
</frameset>
<noframes>
<body>
</body>
</noframes>
</html>
