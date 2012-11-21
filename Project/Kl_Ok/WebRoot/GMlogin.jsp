<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style>
.p1{
	font-size: 50px;
	font-family:"隶书";
	font-weight:bold;
	text-align: center;
	text-shadow: black;
}
</style>
<script type="text/javascript">
function act(){
	var main=document.getElementById("form1");
	
		var logname=document.getElementById("user.uname").value;
		var password=document.getElementById("user.upwd").value;
		if(logname==""){
			alert("用户名不能为空！");
			return;
		}
		if(password==""){
			alert("密码不能为空！");
			return;
		}
		main.action="User_GMLogin.action";
		main.submit();
}
</script>
</head>

<body>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p class="p1">卡拉ok点歌系统管理</p>
<p>&nbsp;</p>
<div align="center">
<form id="form1" name="form1" method="post" action="" >
  <p>管理员账号
    <input type="text" name="user.uname" id="user.uname" />
  </p>
  <p>管理员密码 
    <label for="password"></label>
    <input type="password" name="user.upwd" id="user.upwd" />
  </p>
  <p>
    <input type="submit" name="submit" id="submit" value="登录" onclick="act()" />
  </p>
</form>
</div>
<p>&nbsp;</p>
</body>
</html>
