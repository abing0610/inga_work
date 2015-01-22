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
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="./themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="./themes/icon.css">
	<link rel="stylesheet" type="text/css" href="./css/demo.css">
	<script type="text/javascript" src="./jquery/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="./jquery/jquery.easyui.min.js"></script>
	<script type="text/javascript">
	
		function load(){
			$('#dg').datagrid({
				singleSelect:(this.value==0)
			});
		}
		
		var editIndex = undefined;
		function endEditing(){
			
		}
		function onClickRow(index){
			
		}
		function append(){
			var title = "Add";
			var url = "./main/add.jsp";
			if (window.parent.$('#tt').tabs('exists', title)){
				window.parent.$('#tt').tabs('select', title);
			} else {
				var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
				window.parent.$('#tt').tabs('add',{
					title:title,
					content:content,
					closable:true
				});
			}
			
		}
		//删除的提示窗口
		function removeit(){
			var chk = $("#dg").datagrid('getChecked');
			if(chk.length > 0){
				$('#dlg').dialog('open');
			}else{
				return;
			}
			
		}
		function accept(){
			var flag=false; 
			var idArray="";
			var form = document.idCard2Info;
			var count = 0;
			
	    	// 判断是否选择数据
			for(var i=0;i<form.elements.length;i++) {
				var o=form.elements[i]; 
				if(o.name=="ids" && o.checked==true) { 	
					count = count + 1; 
					if(count == 1) {
						idArray=o.id;
					} else {
						idArray=idArray + "$" + o.id;
					}	
					flag=true;				 
				} 				 
			}
			
			if(flag==false){
				
				return false;
			} else {
				document.getElementById("idCardArrForPrint").value = idArray;
				idCard2Info.action = "idCardNoForPrint.action";
				idCard2Info.submit();
			}
			
		}
		function reject(){
			
		}
		
		function getChanges(){
			
		}
		
		//删除用户信息的操作
		function deleteUser(){
			var chk = $("#dg").datagrid('getChecked');
			
			if(chk.length > 0){
				$('#userdiv').form('submit').action="deleteUser.do";
				$('#userdiv').form('submit').submit();
			}else{
				return;
			}
			
		}
		
		function clearForm(){
			$('#dlg').dialog('close');
		}
		
		$(document).ready(function(){
			/* $.ajax({
			   type: "post",
			   url: "getTreeJson.do",
			   data: "name=inga",
			   success: function(msg){
			   
			    	var zN =eval("(" + msg + ")");
			    	
			    	$.fn.zTree.init($("#treeDemo"), setting, zN);
					zTree_Menu = $.fn.zTree.getZTreeObj("treeDemo");
					curMenu = zTree_Menu.getNodes()[0].children[0].children[0];
					zTree_Menu.selectNode(curMenu);
					var a = $("#" + zTree_Menu.getNodes()[0].tId + "_a");
					a.addClass("cur");
					
			   }
			}); */
			$('#dlg').dialog('close');
			
		});
	</script>
  </head>
  
  <body onload="load()">
    <s:form id="query" name="query" method="post" action="queryUser.do">
    	<s:textfield id="id" name="id" label="ID" />
    	<s:textfield id="name" name="name" label="Name"/>
    	<s:submit value="提交"/>
    </s:form>
    <s:form id="userdiv" name="userdiv" method="post">
	    <table id="dg" class="easyui-datagrid" title="Row Editing in DataGrid" style="height:250px" width="100%"
				data-options="
					iconCls: 'icon-edit',
					singleSelect: true,
					toolbar: '#tb',
					method: 'get',
					onClickRow: onClickRow
				">
			<thead>
				<tr>
					<th data-options="field:'ck',checkbox:true"></th>
					<th width="20%" data-options="field:'productid',align:'center'">Product</th>
					<th width="20%" data-options="field:'listprice',align:'center'">List Price</th>
					<th width="20%" data-options="field:'unitcost',align:'center'">Unit Cost</th>
					<th width="20%" data-options="field:'attr1',align:'center'">Attribute</th>
					<th width="15%" data-options="field:'status',align:'center'">Status</th>
				</tr>
			</thead>
			<s:iterator value="userList" var="user">
				<tr>
					<td><s:property value="#user.id"/></td>
					<td><s:property value="#user.id"/></td>
					<td><s:property value="#user.name"/></td>
					<td><s:property value="#user.usertype"/></td>
					<td><s:property value="#user.cardid"/></td>
					<td><s:property value="#user.uptime"/></td>
				</tr>
		    </s:iterator>
			
		</table>
	
		<div id="tb" style="height:auto">
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">添加</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">删除</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="accept()">Accept</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true" onclick="reject()">Reject</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="getChanges()">GetChanges</a>
		</div>
		
		<div id="dlg" class="easyui-dialog" title="删除确认窗口" data-options="iconCls:'icon-save'" style="width:200px;height:100px;padding:10px">
			<div style="text-align:center;padding:5px">
		    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="deleteUser()">&nbsp;删&nbsp;除&nbsp;</a>
		    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">&nbsp;取&nbsp;消&nbsp;</a>
		    </div>
		</div>
	</s:form>
  </body>
</html>
