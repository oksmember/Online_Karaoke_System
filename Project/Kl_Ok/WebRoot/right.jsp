<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>卡拉ok点歌</title>
</head>

<body>
<p><a href="login.html">登陆</a> <a href="right2.html">查看已点曲目</a></p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<form id="form1" name="form1" method="post" action="">
  <label for="search"></label>
  <input type="text" name="search" id="search" />
  <label>
    <input type="submit" name="submit" id="submit" value="搜索" />
  </label>
</form>
<p>&nbsp;</p>
<p><b>歌曲列表</b>
</p>
<table width="375" border="1" align="center">
  <tr>
    <th width="40" align="center">序号</th>
    <th width="85" align="center">曲名</th>
    <th width="45" align="center">歌手</th>
    <th width="76" align="center">专辑</th>
    <th width="50" align="center">操作</th>
  </tr>
	<s:iterator value="musicList">
  <tr>
  	<td><s:property value="mid"/></td>
    <td><s:property value="mname"/></td>
    <td><s:property value="mart"/></td>
    <td><s:property value="maum"/></td>
    <td><a href="Music_playMusic.action?music.mid=<s:property value="mid"/>" target="mainFrame">点歌</a>|插歌</td>
  </tr>
  </s:iterator>
</table>
<p>&nbsp;</p>
<p>&nbsp;</p>
</body>
</html>
