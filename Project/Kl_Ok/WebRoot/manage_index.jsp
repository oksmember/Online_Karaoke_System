<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>卡拉ok管理站</title>
<style type="text/css">
.body {
	text-align: center;
}
.add {
	text-align: center;
}
</style>
</head>

<body>
<p class="body"><img src="image/logo.gif" width="939" height="70" align="middle" /></p>
<p class="add">&nbsp;</p>
<p class="add"><a href="addinfo.jsp">添加歌曲信息</a></p>
<table width="70%" border="1" align="center">
  <tr>
    <td width="5%">编号</td>
    <td width="15%">曲名</td>
    <td width="10%">歌手</td>
    <td width="15%">专辑</td>
    <td width="20%">视频</td>
    <td width="20%">歌词</td>
    <td width="9%">操作</td>
  </tr>
  <s:iterator value="musicList">
  <tr>
    <td><s:property value="mid"/></td>
    <td><s:property value="mname"/></td>
    <td><s:property value="mart"/><label/></td>
    <td><s:property value="maum"/><label/></td>
    <td><s:property value="mfa"/></td>
    <td><s:property value="msa"/></td>
    <td> <a href="Music_forChangeMusic.action?music.mid=<s:property value="mid"/>">修改</a> | <a href="Music_deleteMusic.action?music.mid=<s:property value="mid"/>">删除</a></td>
  </tr>
  </s:iterator>
</table>
</body>
</html>
