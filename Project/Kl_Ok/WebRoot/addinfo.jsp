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
		var upload1, upload2;

		window.onload = function() {
			upload1 = new SWFUpload({

				//提交路径
				upload_url: "Music_upMusic.action",
				//向后台传递额外的参数
				//post_params: {"name" : "kaobian"},
				//上传文件的名称
				file_post_name: "file",
				
				// 下面自己按照字面意思理解
				file_size_limit : "102400",	// 100MB
				file_types : "*.mp4;*.flv",
				file_types_description : "All Files",
				file_upload_limit : "1",
				file_queue_limit : "0",

				// 事件处理
				file_dialog_start_handler : fileDialogStart,
				file_queued_handler : fileQueued,
				file_queue_error_handler : fileQueueError,
				file_dialog_complete_handler : fileDialogComplete,
				upload_start_handler : uploadStart,
				upload_progress_handler : uploadProgress,
				upload_error_handler : uploadError,
				upload_success_handler : uploadSuccess,
				upload_complete_handler : uploadComplete,

				// 按钮的处理
				button_image_url : "images/XPButtonUploadText_61x22.png",
				button_placeholder_id : "spanButtonPlaceholder1",
				button_width: 61,
				button_height: 22,
				
				// Flash Settings
				flash_url : "js/swfupload.swf",
				

				custom_settings : {
					progressTarget : "fsUploadProgress1",
					cancelButtonId : "btnCancel1"
				},
				
				// Debug Settings
				debug: false
			});
			
			upload2=new SWFUpload({

				//提交路径
				upload_url: "Music_upLrc.action",
				//向后台传递额外的参数
				//post_params: {"name" : "kaobian"},
				//上传文件的名称
				file_post_name: "file",
				
				// 下面自己按照字面意思理解
				file_size_limit : "102400",	// 100MB
				file_types : "*.lrc",
				file_types_description : "All Files",
				file_upload_limit : "1",
				file_queue_limit : "0",

				// 事件处理
				file_dialog_start_handler : fileDialogStart,
				file_queued_handler : fileQueued,
				file_queue_error_handler : fileQueueError,
				file_dialog_complete_handler : fileDialogComplete,
				upload_start_handler : uploadStart,
				upload_progress_handler : uploadProgress,
				upload_error_handler : uploadError,
				upload_success_handler : uploadSuccess,
				upload_complete_handler : uploadComplete,

				// 按钮的处理
				button_image_url : "images/XPButtonUploadText_61x22.png",
				button_placeholder_id : "spanButtonPlaceholder2",
				button_width: 61,
				button_height: 22,
				
				// Flash Settings
				flash_url : "js/swfupload.swf",
				

				custom_settings : {
					progressTarget : "fsUploadProgress2",
					cancelButtonId : "btnCancel2"
				},
				
				// Debug Settings
				debug: false
			});
	     };
	    
	    function add(){
	    	var main=document.getElementById("form1");
	    	
	    	var mname=document.getElementById("music.mname").value;
	    	if(mname==""){
	    		alert("曲名不可为空");
	    		return;
	    	}
	    	
	    	main.action="Music_addMusic.action";
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
      <input type="text" name="music.mname" id="music.mname" /></td>
    </tr>
    <tr>
      <th scope="row">曲目歌手</th>
      <td><label for="music.mart"></label>
      <input type="text" name="music.mart" id="music.mart" /></td>
    </tr>
    <tr>
      <th scope="row">曲目专辑</th>
      <td><label for="music.aum"></label>
      <input type="text" name="music.maum" id="music.maum" /></td>
    </tr>
    <tr>
      <th scope="row">制作公司</th>
      <td><label for="music.mc"></label>
      <input type="text" name="music.mc" id="music.mc" /></td>
    </tr>
    <tr>
      <th scope="row">发行年份</th>
      <td><label for="music.my"></label>
      <input type="text" name="music.my" id="music.my" /></td>
    </tr>
    <tr valign="top" >
		<td colspan="2" scope="row">
			<div>
				<div class="fieldset flash" id="fsUploadProgress1">
					<span class="legend">上传视频</span>
				</div>
				<div style="padding-left: 5px;">
					<span id="spanButtonPlaceholder1"></span>
					<input id="btnCancel1" type="button" value="Cancel Uploads" onclick="cancelQueue(upload1);" disabled="disabled" style="margin-left: 2px; height: 22px; font-size: 8pt;" />
					<br />
				</div>
			</div>
		</td>
	</tr>
    <tr valign="top">
		<td colspan="2" scope="row">
			<div>
				<div class="fieldset flash" id="fsUploadProgress2">
					<span class="legend">上传歌词</span>
				</div>
				<div style="padding-left: 5px;">
					<span id="spanButtonPlaceholder2"></span>
					<input id="btnCancel2" type="button" value="Cancel Uploads" onclick="cancelQueue(upload2);" disabled="disabled" style="margin-left: 2px; height: 22px; font-size: 8pt;" />
					<br />
				</div>
			</div>
		</td>
	</tr>
    <tr>
      <th scope="row">会员标识</th>
      <td><label for="music.my"></label>
      <input type="radio" name="flag" id="flag" value="0" checked="checked"/>非会员
      <input type="radio" name="flag" id="flag" value="1" />会员</td>
    </tr>
    <tr>
      <th colspan="2" scope="row"><input type="button" name="button" id="button"onclick="add()" value="提交歌曲信息" /></th>
    </tr>
  </table>
</form>
<p class="add">&nbsp;</p>
<p class="add">&nbsp;</p>
<p>&nbsp;			</p>
</body>
</html>
