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
   	<script type="text/javascript" src="<%=basePath%>js/swfupload.js"></script>
   	<script type="text/javascript" src="<%=basePath%>js/swfupload.queue.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/fileprogress.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/handlers.js"></script>
<title>卡拉ok管理站</title>
<link href="<%=basePath%>css/default.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.body {
	text-align: center;
}
.add {
	font-size:30px;
	font-family:"隶书";
	font-weight:bold;
	text-align: center;
}
</style>  
   	<!-- 初始化swfupload 对象-->
   <script type="text/javascript">
	    function change(){
	    	var main=document.getElementById("form1");
	    	
	    	var mname=document.getElementById("music.mname").value;
	    	if(mname==""){
	    		alert("曲名不可为空");
	    		return;
	    	}
	    	
	    	main.action="Music_changeMusic.action?music.mid="+${music.mid};
	    	main.submit();
	    }
	</script>
</head>

<body>
<p class="body"><img src="image/logo.gif" width="939" height="70" align="middle" /></p>
<p class="add">&nbsp;</p>
<p class="add">添加歌曲信息</p>
<form action="" method="post" enctype="multipart/form-data" name="form1" id="form1">
  <table width="391" border="0" align="center">
    <tr>
      <th width="141" scope="row">曲目名称</th>
      <td width="240"><label for="music.mname"></label>
      <input type="text" name="music.mname" id="music.mname" value="<s:property value="music.mname"/>"/></td>
    </tr>
    <tr>
      <th scope="row">曲目歌手</th>
      <td><label for="music.mart"></label>
      <input type="text" name="music.mart" id="music.mart" value="<s:property value="music.mart"/>"/></td>
    </tr>
    <tr>
      <th scope="row">曲目专辑</th>
      <td><label for="music.aum"></label>
      <input type="text" name="music.maum" id="music.maum" value="<s:property value="music.maum"/>"/></td>
    </tr>
    <tr>
      <th scope="row">制作公司</th>
      <td><label for="music.mc"></label>
      <input type="text" name="music.mc" id="music.mc" value="<s:property value="music.mc"/>"/></td>
    </tr>
    <tr>
      <th scope="row">发行年份</th>
      <td><label for="music.my"></label>
      <input type="text" name="music.my" id="music.my" value="<s:property value="music.my"/>"/></td>
    </tr>
    <tr>
      <th scope="row">会员标识</th>
      <td><label for="music.my"></label>
      <s:if test="%{flag==0 }">
      <input type="radio" name="flag" id="flag" value="0" checked="checked"/>非会员
      <input type="radio" name="flag" id="flag" value="1" />会员</td>
      </s:if>
      <s:else>
      <input type="radio" name="flag" id="flag" value="0"/>非会员
      <input type="radio" name="flag" id="flag" value="1"  checked="checked"/>会员</td>
      </s:else>
    </tr>
    <tr>
      <th colspan="2" scope="row"><input type="button" name="button" id="button"onclick="change()" value="修改" /></th>
    </tr>
  </table>
</form>
<p class="add">&nbsp;</p>
<p class="add">&nbsp;</p>
<p>&nbsp;			</p>
</body>
</html>
