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
            body{background: url(images/regin.jpg) no-repeat;background-size:cover;font-size: 16px;}  
            .form{background: rgba(255,255,255,0.2);width:400px;margin:100px auto;}  
            #login_form{display: block;}  
            #register_form{display: none;}  
            .fa{display: inline-block;top: 27px;left: 6px;position: relative;color: #ccc;}  
            input[type="text"],input[type="password"]{padding-left:26px;}  
            .checkbox{padding-left:21px;}  
        </style>  
  </head>
  <body>
	 <div class="container">  
        <div class="form row">  
            <form method="post" class="form-horizontal col-sm-offset-3 col-md-offset-3" id="login_form">  
                <h3 class="form-title">网上书城</h3>  
                <div class="col-sm-9 col-md-9">  
                    <div class="form-group">  
                        <i class="fa fa-user fa-lg"></i>  
                        <input class="form-control required" id="inputuser" type="text" placeholder="Username" name="username" autofocus="autofocus" maxlength="20"/>  
                    </div>  
                    <div class="form-group">  
                            <i class="fa fa-lock fa-lg"></i>  
                            <input class="form-control required" id="inputPassword" type="password" placeholder="Password" name="password" maxlength="8"/>  
                    </div>  
                    <div class="form-group">  
                        <label class="checkbox">  
                            <input type="checkbox" name="remember" value="1"/> Remember me  
                        </label>  
                        <hr />  
                        <a href="javascript:;" id="register_btn" class="">Create an account</a>  
                    </div>  
                    <div class="form-group">  
                        <input id="sub" type="button" class="btn btn-success pull-right" value="Login "/>     
                    </div>  
                </div>  
            </form>  
        </div>  
        <div class="form row">  
            <form method="post" class="form-horizontal col-sm-offset-3 col-md-offset-3" id="register_form">  
                <h3 class="form-title">注册你的账户</h3>  
                <div class="col-sm-9 col-md-9">  
                    <div class="form-group">  
                        <i class="fa fa-user fa-lg"></i>  
                        <input class="form-control required" type="text" placeholder="Username" id="register_name" name="username" autofocus="autofocus"/>  
                    </div>  
                    <div class="form-group">  
                            <i class="fa fa-lock fa-lg"></i>  
                            <input class="form-control required" type="password" placeholder="Password" id="register_password" name="password"/>  
                    </div>  
                    <div class="form-group">  
                            <i class="fa fa-check fa-lg"></i>  
                            <input class="form-control required" type="password" placeholder="Re-type Your Password" name="rpassword"/>  
                    </div>  
                    <div class="form-group">  
                        <input id="reginbtn" type="button" class="btn btn-success pull-right" value="Sign Up "/>  
                        <input type="submit" class="btn btn-info pull-left" id="back_btn" value="Back"/>  
                    </div>  
                </div>  
            </form>  
        </div>  
        </div> 
        <script type="text/javascript">
        $(function() {  
            $("#register_btn").click(function() {  
                $("#register_form").css("display", "block");  
                $("#login_form").css("display", "none");  
            });  
            $("#back_btn").click(function() {  
                $("#register_form").css("display", "none");  
                $("#login_form").css("display", "block");  
            });  
        }); 
        </script> 
        <script type="text/javascript">
    //用户登入功能
      $(function(){
    	  $("#sub").click(function(){
    		 var name= $("#inputuser").val();
    		 var password = $("#inputPassword").val();
    		 if(name!==""&&password!==""){
    		 $.ajax({
    			url:"user/login.action",
    		 	data:{"name":name,"password":password},
    		 	dataType:"json",
    		 	type:"post",
    		 	success:function(data){
    		 		console.log(data);
    		 		if(data==1){
    		 			layer.msg("登入成功");
    		 			window.location.href="store/StoreCent.action";
    		 		}else if(data==0){
    		 			layer.msg("用户不存在,请注册用户");
    		 		}else if(data==2){
    		 			layer.msg("密码错误");
    		 		}
    		 	}
    		 })
    		 }else{
    			 layer.msg("用户或密码不能为空")
    		 }
    		 
    	  })
      })
    </script>
    
    
    
    
    
           <script type="text/javascript">
    //用户注册功能
      $(function(){
    	  $("#reginbtn").click(function(){
    		 var name= $("#register_name").val();
    		 var password = $("#register_password").val();
    		 console.log(name);
    		 if(name!==""&&password!==""){
    		 $.ajax({
    			url:"user/regin.action",
    		 	data:{"name":name,"password":password},
    		 	dataType:"json",
    		 	type:"post",
    		 	success:function(data){
    		 		console.log(data);
    		 		if(data==1){
    		 			layer.msg("注册成功");
    		 		}else if(data==0){
    		 			layer.msg("注册失败");
    		 		}else if(data==2){
    		 			layer.msg("改用户名已存在");
    		 		}
    		 	}
    		 })
    		 }else{
    			 layer.msg("用户或密码不能为空")
    		 }
    		 
    	  })
      })
    </script>
</body>
</html>
