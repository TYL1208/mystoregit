<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ok.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <link href="css/bootstrap.min.css" rel="stylesheet">
	   <script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>  
   <script src="${pageContext.request.contextPath }/js/layer/layer.min.js"></script> 
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>  
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<style type="text/css">
		.container{
			margin-top:100px;
			width: 500px;
			height: 500px;
		}	
		.title{
		   margin-left: 170PX;
		}
	</style>

  </head>
  
  <body>
	 <div class="container">
              <form id="formb"  class="form-signin">
                <div class="title">
                <h3 class="form-signin-heading">网上书城</h3>
                <h5 id="ms" class="form-signin-heading"></h5>
                </div>
                <label for="inputEmail" class="sr-only">用户名</label>
                <input id="inputuser" name="username" class="form-control" placeholder="用户名" required="" autofocus="" type="text">
                <label for="inputPassword" class="sr-only">密码</label>
                <input name="password" id="inputPassword" class="form-control" placeholder="密码" required="" type="password">
                <div class="checkbox">
                   <button  id="regin" class="" type="button">注册</button>
                   <button  id="end" class="" type="button">退出</button>
                </div>
                <button id="sub" class="btn btn-lg btn-primary btn-block" type="button">登入</button>
              </form>
    </div> <!-- /container -->
    
    <script type="text/javascript">
    //用户登入功能
      $(function(){
    	  $("#sub").click(function(){
    		 var name= $("#inputuser").val();
    		 var password = $("#inputPassword").val();
    		 $.ajax({
    			url:"user/login.action",
    		 	data:{"name":name,"password":password},
    		 	dataType:"json",
    		 	type:"post",
    		 	success:function(data){
    		 		console.log(data);
    		 		if(data==1){
    		 			layer.msg("登入成功");
    		 		}else if(data==0){
    		 			layer.msg("用户不存在,请注册用户");
    		 		}else if(data==2){
    		 			layer.msg("密码错误");
    		 		}
    		 	}
    		 })
    	  })
      })
    </script>
    <script type="text/javascript">
      //用户注册功能
      $(function(){
       $("#regin").click(function(){
    	     window.location.href="resign.jsp";
    	  })
      })
    </script>
    
    </script>
</body>
</html>
