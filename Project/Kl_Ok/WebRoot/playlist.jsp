<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style type="text/css">
.box{
	font-size:12px;
}
</style>
 <script type="text/javascript" src="jquery/js/jquery-1.3.2.min.js"></script>
 <script type="text/javascript" src="jquery/js/jquery-ui-1.7.2.custom.min.js"></script>
<script type="text/javascript">
	function start(){
		parent.rightFrame.location.href="Ulist_forPlayList.action";
	}
	
	function sub(){
		var search=document.getElementById("search").value;
		var main=document.getElementById("searchform");
		if(search==""){
			alert("搜索栏不可为空");
			return;
		}
		main.action="Music_userSearch.action";
		main.submit();
	}
</script>
</head>

<body>
	<p>
		欢迎${user.uname } &nbsp;&nbsp;&nbsp;&nbsp;<a href="Ulist_forPlayList.action">查看播放列表</a>&nbsp;&nbsp;<a href="Music_forUserMusicList.action">返回</a>
	</p>
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
	<p>
		<b>已选曲目</b>
	</p>
<table width="100%" border="1" align="center" class="box">
  <tr>
    <th width="10%" align="center">序列</th>
    <th width="23%" align="center">曲名</th>
    <th width="15%" align="center">歌手</th>
    <th width="20%" align="center">专辑</th>
    <th width="20%" align="center">操作</th>
  </tr>
  <tr>
	<s:if test="%{num==0}">
		<td colspan="5" scope="row">播放列表中没有曲目</td>
	</s:if>
	<s:else>
			<td>1
			</td>
			<td><s:property value="music.mname" />
			</td>
			<td><label><s:property value="music.mart" />&nbsp;</label>
			</td>
			<td><label><s:property value="music.maum" />&nbsp;</label>
			</td>
			<td>
	<a href="Music_startPlay.action" target="mainFrame" onclick="javascript:window.setTimeout('start()', 1000);" title="播放已点列表中第一首">播放</a>
	|&nbsp;&nbsp;<a href="Ulist_delete.action?listItem.lid=<s:property value="id"/>">删除</a>
	</td>
	</s:else>
		</tr>
		<s:iterator value="ulist">
			<tr>
				<td><s:property value="no" />
				</td>
				<td><s:property value="music.mname" />
				</td>
				<td><label><s:property value="music.mart" />&nbsp;</label>
				</td>
				<td><label><s:property value="music.maum" />&nbsp;</label>
				</td>
				<td><a href="Ulist_upList.action?music.mid=<s:property value="music.mid"/>&listItem.no=<s:property value="no"/>">插歌</a>&nbsp;&nbsp;|
				&nbsp;&nbsp;<a href="Ulist_delete.action?listItem.lid=<s:property value="lid"/>">删除</a></td>
			</tr>
		</s:iterator>
	</table>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
</body>
</html>
