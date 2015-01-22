<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Add PaGe</title>
    
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
	<script type="text/javascript">
		$(document).ready(function(){
			//获取province的信息
			$.ajax({
			   type: "post",
			   url: "getProvince.do",
			   success: function(msg){
			    	var zN =eval("(" + msg + ")");
			    	
			    	for(var i=0 ; i < zN.length ; i++){
			    		$("#province").append("<option value='"+zN[i].province+"'>"+ zN[i].name+"</option>");
			    	}
			   }
			});
			
		});
	</script>

  </head>
  
  <body>
    <div class="easyui-panel" title="New Topic" style="width:400px">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff" method="post" action="addUser.do">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>ID:</td>
	    			<td><input class="easyui-textbox" type="text" name="id" id="id" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>NAME:</td>
	    			<td><input class="easyui-textbox" type="text" name="name" id="name" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>PROVINCE:</td>
	    			<td>
	    					<select id="province" name="province" style="width:130px;">
	    						<option value="">城市列表</option>
	    					</select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>USERTYPE:</td>
	    			<td><input class="easyui-textbox" type="text" name="usertype" id="usertype" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>CARDID:</td>
	    			<td><input class="easyui-textbox" type="text" name="cardid" id="cardid" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>WORK:</td>
	    			<td><input class="easyui-textbox" type="text" name="work" id="work" data-options="required:true"></input></td>
	    		</tr>
	    		<!-- <tr>
	    			<td>UPTIME:</td>
	    			<td><input class="easyui-textbox" type="text" name="uptime" id="uptime" data-options="required:true"></input></td>
	    		</tr> -->
	    		<!-- <tr>
	    			<td>REMARK:</td>
	    			<td><input class="easyui-textbox" name="remark" id="remark" data-options="multiline:true" style="height:60px"></input></td>
	    		</tr> -->
	    		
	    	</table>
	    	
	    	<div style="text-align:center;padding:5px">
		    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">Submit</a>
		    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">Clear</a>
		    </div>
	    </form>
	    </div>
	</div>
	<script>
		function submitForm(){
			var id=$("#id").val();
			var name=$("#name").val();
			var province=$("#province").val();
			var usertype=$("#usertype").val();
			var cardid=$("#cardid").val();
			var work=$("#work").val();
			//var uptime=$("#uptime").val();
			if(province == ""){
				alert("请选择城市列表");
				return ;
			}
			if(id=="" || name=="" || usertype == "" || cardid == "" || work == ""){
				return;
			}else{
			
				$.ajax({
				   type: "post",
				   url: "addUser.do",
				   data:{
				   		id:id,
				   		name:name,
				   		province:province,
				   		usertype:usertype,
				   		cardid:cardid,
				   		work:work
				   },
				   success: function(msg){
				   
				    	var zN =eval("(" + msg + ")");
				    	
				    	if(zN){
				    		alert("添加用户成功！");
				    	}else{
				    		alert("添加失败!");
				    	}
				    	
				   }
				});
			}
		}
		function clearForm(){
			$('#ff').form('clear');
		}
	</script>
  </body>
</html>
