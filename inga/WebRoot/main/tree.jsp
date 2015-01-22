<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Tree</title>
    
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
	
	<link rel="stylesheet" href="./css/demo1.css" type="text/css">
	<link rel="stylesheet" href="./css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="./js/jquery.ztree.core-3.5.js"></script>
	
	<script type="text/javascript">
		var setting = {
			data: {
				key: {
					title:"path"
				},
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeClick: beforeClick,
				onClick: onClick
			}
		};

		var log, className = "dark";
		function beforeClick(treeId, treeNode, clickFlag) {
			
			return ;
		}
		function onClick(event, treeId, treeNode, clickFlag) {
		
		}		
		function showLog(str) {
			if (!log) log = $("#log");
			log.append("<li class='"+className+"'>"+str+"</li>");
			if(log.children("li").length > 8) {
				log.get(0).removeChild(log.children("li")[0]);
			}
		}
		//获取系统时间
		function getTime() {
			var now= new Date(),
			h=now.getHours(),
			m=now.getMinutes(),
			s=now.getSeconds();
			return (h+":"+m+":"+s);
		}

		/*
			页面进来以后，进行方法的加载
		*/
		$(document).ready(function(){
			$.ajax({
			   type: "post",
			   url: "getTreeJson.do",
			   data: "name=inga",
			   success: function(msg){
			       var zN =eval("(" + msg + ")");
			       
			       $.fn.zTree.init($("#treeDemo"), setting, zN);
			   }
			});
			
			$("#dlg").dialog("close");
			$("#addTree").bind("click", {isParent:true}, add);
			$("#delTree").bind("click", {isParent:true}, del);
		});
		
		function add(e) {
			
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			nodes = zTree.getSelectedNodes(),
			treeNode = nodes[0];
			
			if(treeNode == undefined){
				alert("请点击根节点");
				return;
			}
			if(treeNode.path == undefined){
				
				//给dialog弹出的对话框
				$("#pId").val(treeNode.id);
	            $("#dlg").dialog("open");
	            
			}else{
				alert("请点击根节点");
				return;
			}
		};
		/*
			去除字符串中左右两端的空格
		*/
		function trim(str){
		   return str.replace(/(^\s*)|(\s*$)/g, "");
		}
		/*
			添加树节点
		*/
		function addTreeNode(){
			var pId = trim($("#pId").val());
			var id = trim($("#id").val());
			var name = trim($("#name").val());
			var acturl = trim($("#acturl").val());
			if(pId!="" && id!="" && name!=""){
				if(acturl != ""){
					acturl = acturl;
				}else{
					acturl = "#";
				}
				$.ajax({
				   type: "post",
				   url: "insertTreeNode.do",
				   data: {
				   		id:id,
				   		pId:pId,
				   		name:name,
				   		acturl:acturl
				   },
				   success: function(msg){
				    	var zN =eval("(" + msg + ")");
						//alert(zN);
				   }
				});
			}else{
				alert("请输入信息");
				return;
			}
			
			$("#dlg").dialog("close");
		}
		/*
			删除节点
			
		*/
		function del(e) {
			
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			nodes = zTree.getSelectedNodes(),
			treeNode = nodes[0];
			
			if(treeNode == undefined){
				alert("请点击节点");
				return;
			}
			$.ajax({
				   type: "post",
				   url: "delTreeNode.do",
				   data: {
				   		id:treeNode.id,
				   		pId:treeNode.pId
				   },
				   success: function(msg){
				    	var zN =eval("(" + msg + ")");
						//alert(zN);
						alert("删除成功");
				   }
				});
			
		};
		
	</script>
  </head>
  
  <body>
	<div class="content_wrap">
		<div class="zTreeDemoBackground left">
			<ul id="treeDemo" class="ztree"></ul>
		</div>
		
		<div class="right">
			<div style="margin:10px 0;">
				<a href="javascript:void(0)" id="addTree" class="easyui-linkbutton">新增</a>
				<a href="javascript:void(0)" id="delTree" class="easyui-linkbutton" onclick="delTree()">删除</a>
			</div>
		</div>
	</div>
	
	<div id="dlg" class="easyui-dialog" title="Complex Toolbar on Dialog" style="width:400px;height:200px;padding:10px"
			data-options="
				iconCls: 'icon-save',
				buttons: '#dlg-buttons'
			">
			<table>
	    		<tr>
	    			<td><s:textfield id="id" class="easyui-textbox"  name="id" label="id"/></td>
	    		</tr>
	    		<tr>
	    			<td><s:textfield id="pId" class="easyui-textbox" name="pId" label="pId"/></td>
	    		</tr>
	    		<tr>
	    			<td><s:textfield id="name" class="easyui-textbox" name="name" label="name"/></td>
	    		</tr>
	    		<tr>
	    			<td><s:textfield id="acturl" class="easyui-textbox" name="acturl" label="acturl"/></td>
	    		</tr>
    		</table>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="addTreeNode()">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#dlg').dialog('close')">Close</a>
	</div>
	
  </body>
</html>