<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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
	<script src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>  
    	<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>  
    <script type="text/javascript">
     $(function(){
    	$("#butt").click(function(){
    	 var jso={"username":$("input[name='username']").val(),"psd":$("input[name='psd']").val()};
    	 var str=JSON.stringify(jso);
    		console.log($("input[name='username']").val());
    		$.ajax({
    			url:"user/log.action",
    			contentType:'application/json;charset=utf-8',
    			data:str,
    			type:"post",
    			dataType:"json",
    			success:function(data){
    				console.log(data);
    			}
    		})
    	})
    	 
     })
    </script>
  </head>
  
  <body>
    <form action="user/log.action" method="post">
    ${psd }
    用户名:<input  name="username" type="text" /><br/>
       用户名:<input name="psd" type="password" /><br/>
       <input type="submit" value="提交">
         <input id="butt" type="button" value="ajax">
    </form>
  </body>
</html>
