<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>InGa PaGe</title>
    
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
		
		function addTab(title, url){
			if ($('#tt').tabs('exists', title)){
				$('#tt').tabs('select', title);
			} else {
				var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
				$('#tt').tabs('add',{
					title:title,
					content:content,
					closable:true
				});
			}
		}
		
		var curMenu = null, zTree_Menu = null;
		var setting = {
			view: {
				showLine: true,
				selectedMulti: false,
				dblClickExpand: false
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				onNodeCreated: this.onNodeCreated,
				beforeClick: this.beforeClick,
				onClick: this.onClick
			}
		}; 

		function beforeClick(treeId, node) {
			if (node.isParent) {
				if (node.level === 0) {
					var pNode = curMenu;
					while (pNode && pNode.level !==0) {
						pNode = pNode.getParentNode();
					}
					if (pNode !== node) {
						var a = $("#" + pNode.tId + "_a");
						a.removeClass("cur");
						zTree_Menu.expandNode(pNode, false);
					}
					a = $("#" + node.tId + "_a");
					a.addClass("cur");

					var isOpen = false;
					for (var i=0,l=node.children.length; i<l; i++) {
						if(node.children[i].open) {
							isOpen = true;
							break;
						}
					}
					if (isOpen) {
						zTree_Menu.expandNode(node, true);
						curMenu = node;
					} else {
						zTree_Menu.expandNode(node.children[0].isParent?node.children[0]:node, true);
						curMenu = node.children[0];
					}
				} else {
					zTree_Menu.expandNode(node);
				}
			}
			return !node.isParent;
		}
		function onClick(e, treeId, node) {
			//路径
			var url = node.path;
			//tab的名字
			var title = node.name;
			if ($('#tt').tabs('exists', title)){
				$('#tt').tabs('select', title);
			} else {
				var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
				$('#tt').tabs('add',{
					title:title,
					content:content,
					closable:true
				});
			}
		}

		$(document).ready(function(){
			$.ajax({
			   type: "post",
			   url: "getTreeJson.do",
			   success: function(msg){
			   
			    	var zN =eval("(" + msg + ")");
			    	
			    	$.fn.zTree.init($("#treeDemo"), setting, zN);
					zTree_Menu = $.fn.zTree.getZTreeObj("treeDemo");
					curMenu = zTree_Menu.getNodes()[0].children[0].children[0];
					zTree_Menu.selectNode(curMenu);
					var a = $("#" + zTree_Menu.getNodes()[0].tId + "_a");
					a.addClass("cur");
					
			   }
			});
		});
	
		
	</script>
	<style type="text/css">
	.ztree li a.level0 {width:180px;height: 20px; text-align: center; display:block; background-color: #0B61A4; border:1px silver solid;}
	.ztree li a.level0.cur {background-color: #66A3D2; }
	.ztree li a.level0 span {display: block; color: white; padding-top:3px; font-size:12px; font-weight: bold;word-spacing: 2px;}
	.ztree li a.level0 span.button {	float:right; margin-left: 10px; visibility: visible;display:none;}
	.ztree li span.button.switch.level0 {display:none;}
	</style>
  </head>
  
  <body class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">north region</div>
	
	<div data-options="region:'west',split:true,title:'West'" style="width:230px;padding:10px;background: #f0f6e4;">
		<ul id="treeDemo" class="ztree"></ul> 
	</div>
	
	<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div>
	 
	<div id="tt" data-options="region:'center',title:'Center'" class="easyui-tabs">
		<div title="Help" style="width:100%;" id="heee">
			This is the help content.
			asdasfdasfd
		</div>
	</div>
	
  </body>
</html>
