<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title> 你好</title>
	<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
	<script type="text/javascript">
	
	function savePerson(){
	    var savePerson = {"id":info.id,"name":"update"+info.name,"sex":info.sex}; //发送给服务器的JSON
	    jQuery.ajax({
		    type : "PUT",
		    url : "<%=basePath%>update",
		    data:JSON.stringify(savePerson),
		    contentType:"application/json",  //发送至服务器的类型
		    dataType : "text",               //预期服务器返回类型
		    //dataType : "json",               //预期服务器返回类型
		    success: function(data){
		    	if(data=="success"){
					alert("新增成功");
					location.href="<%=basePath%>index";
				}
		    }
	    })
	}
	function deletePerson(){
		var savePerson = {"id":info.pid,"name":"delete"+info.pname,"sex":info.psex}; //发送给服务器的JSON
		jQuery.ajax({
		    type : "DELETE",
			url : "<%=basePath%>deleteFunc",
			data:JSON.stringify(savePerson),
			contentType:"application/json",  //发送至服务器的类型
			dataType : "text",               //预期服务器返回类型
			success: function(data){
			    alert("删除成功");
			    location.href="<%=basePath%>index";
			}
		})
    }
	</script>
</head>
<body>
	<div>${helloworld}</div>
	<form action="<%=basePath%>insert" method="post" name="info">
         <input type="text" name="pid"/> 
         <input type="text" name="pname"/> 
         <input type="text" name="psex"/>
         <input type="submit"/>
    </form>
    <div>
        <label>ID:${id}</label>
        <label>Name:${name}</label>
        <label>Sex:${sex}</label>
    </div>
    <div>
        <input type="button" value="保存" onclick="savePerson()"/>
        <input type="button" value="删除" onclick="deletePerson()"/>
    </div>
</body>
</html>