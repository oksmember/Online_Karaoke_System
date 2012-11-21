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
		main.action="User_Login.action";
		main.submit();
}
</script>
</head>

<body>
<p><a href="login.jsp">登录</a></p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<form id="form1" name="form1" method="post" action="" target="rightFrame">
  <p>用户名
    <input type="text" name="user.uname" id="user.uname" />
  </p>
  <p>密   码 
    <label for="password"></label>
    <input type="password" name="user.upwd" id="user.upwd" />
  </p>
  <p>
    <input type="submit" name="submit" id="submit" value="登录" onclick="act()" />
  </p>
</form>
<p>&nbsp;</p>
<p><a href="right.jsp">返回</a></p>
</body>
</html>
