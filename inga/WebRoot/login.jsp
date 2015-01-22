<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="./themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="./themes/icon.css">
	<link rel="stylesheet" type="text/css" href="./css/demo.css">
	<script type="text/javascript" src="./jquery/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="./jquery/jquery.easyui.min.js"></script>
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function loginl(){
			//alert("1");
			var id = document.getElementById("id").value;
			var password = document.getElementById("password").value;
			
			if(id==""||password==""){
				alert("输入信息");
				return;
			}
			
			//document.login.action="login.action";
			document.login.submit();
			
		
		}
	</script>

  </head>
  
  <body>
  	<form name="login" action="login.do" method="post">
	    <div class="easyui-panel" title="Login to system" style="width:400px;padding:30px 70px 20px 70px">
			<div style="margin-bottom:10px">
				<input id="id" name="id" class="easyui-textbox" style="width:100%;height:40px;padding:12px" data-options="prompt:'Username',iconCls:'icon-man',iconWidth:38">
			</div>
			<div style="margin-bottom:20px">
				<input id="password" name="password" class="easyui-textbox" type="password" style="width:100%;height:40px;padding:12px" data-options="prompt:'Password',iconCls:'icon-lock',iconWidth:38">
			</div>
			<div>
				<!-- <a href="#" onclick="login();" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="padding:5px 0px;width:100%;">
					<span style="font-size:14px;" >Login</span>
				</a>  -->
				<input type="button" onclick="loginl()" value="Login"/>
			</div>
		</div>
	</form>
	
	<br/><br/><br/><br/>
	${ok}
  </body>
</html>
