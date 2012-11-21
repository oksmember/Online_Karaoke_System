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
<style type="text/css">
.box{
	font-size:12px;
}
</style>
<script type="text/javascript">
	function sub(){
		var search=document.getElementById("search").value;
		var main=document.getElementById("searchform");
		if(search==""){
			alert("搜索栏不可为空");
			return;
		}
		main.action="Music_noUserSearch.action";
		main.submit();
	}
	
</script>
</head>

<body>
<p><a href="login.jsp">登录</a></p>
<p>&nbsp;</p>
<p><b>搜索曲目</b></p>
<form id="searchform" name="searchform" method="post" action="" target="rightFrame">
  <label for="search"></label>
  <input type="text" name="search" id="search" /><br>
  <label>
      <input type="radio" name="flag" id="flag" value="1" checked="checked"/>曲名
      <input type="radio" name="flag" id="flag" value="2" />歌手
      <input type="radio" name="flag" id="flag" value="3" />专辑<br>
    <input type="button" value="搜索" onclick="sub()"/>
  </label>
</form>
<p>&nbsp;</p>
<p><b>歌曲列表</b>
</p>
<table width="100%" border="1" align="center" class="box">
  <tr>
    <th width="10%" align="center">编号</th>
    <th width="23%" align="center">曲名</th>
    <th width="15%" align="center">歌手</th>
    <th width="20%" align="center">专辑</th>
    <th width="20%" align="center">操作</th>
  </tr>
	<s:iterator value="musicList">
  <tr>
  	<td><s:property value="mid"/></td>
    <td><s:property value="mname"/></td>
    <td><label><s:property value="mart"/>&nbsp;</label></td>
    <td><label><s:property value="maum"/>&nbsp;</label></td>
    <td><a href="Music_playMusic.action?music.mid=<s:property value="mid"/>" target="mainFrame">点歌</a></td>
  </tr>
  </s:iterator>
</table>
<p>&nbsp;</p>
<p>&nbsp;</p>
</body>
</html>
