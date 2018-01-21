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
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	 <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<style type="text/css">
		.titleCente{
		  height: 60px;
		 
		}
		.formc{
		  height: 60px;
		  width:350px;
		  float: right;
		}
		.uu{
		height: 10px;
		  width:150px;
		  color: red;
		  
		}
	
		
	</style>
  </head>
  
  <body>
	<div class="ibox-content text-center p-md">

		<div class="m-t-md">
			<h2>
			购物车
			</h2>
			<div class="p-lg ">
				<div class="ibox-content">

					<div class="col-sm-12">
						<div class="ibox float-e-margins">
							<div class="ibox-content">
								<div id="DataTables_Table_0_wrapper"
									class="dataTables_wrapper form-inline" role="grid">
									<div class="row">
										<div class="col-sm-6">
											<div class="dataTables_length" id="DataTables_Table_0_length">
											</div>
										</div>
									<div class="titleCente" >
									<h4 class="uu">${user.name }欢迎你</h4>
									<h4 class="uu"><a href="store/StoreCent.action" >首页</a></h4>
									<div class="formc">
										<span>总价</span>:<input id="countprice" type="text" value="">
									<button id="btnn" value="计算">计算</button>
									<button id="sub" value="计算">提交</button>
									<input name="user" value="${user.id}" type="hidden" />
									</div>
									</div>
									</div>
									<div class="tabl">
									<table
										class="table table-striped table-bordered table-hover dataTables-example dataTable"
										id="DataTables_Table_0"
										aria-describedby="DataTables_Table_0_info">
										<thead>
											<tr role="row">
												<th class="sorting_asc" tabindex="0"
													aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
													style="width: 100px;" aria-sort="ascending"
													aria-label="渲染引擎：激活排序列升序">编号</th>
												<th class="sorting" tabindex="0"
													aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
													style="width: 200px;" aria-label="浏览器：激活排序列升序">书名</th>
												<th class="sorting" tabindex="0"
													aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
													style="width: 200px;" aria-label="平台：激活排序列升序">图片</th>
												<th class="sorting" tabindex="0"
													aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
													style="width: 150px;" aria-label="引擎版本：激活排序列升序">单价</th>
														<th class="sorting" tabindex="0"
													aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
													style="width: 150px;" aria-label="引擎版本：激活排序列升序">操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${items }" var="p">
												<tr class="gradeA odd">
													<td class="sorting_1">${p.id }</td>
													<td class=" ">${p.book.bookname}</td>
													<td class=" "><img alt="" src="images/${p.book.images}"></td>
													<td class="center ">${p.book.price}</td>
													<td class="center "><input type="checkbox" name="pay" value="${p.book.price}+${p.id }"></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<!-- 总价:<input id="countprice" type="text" value="">
									<button id="btnn" value="计算">计算</button>
									<button id="sub" value="计算">提交</button> -->
										</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$("#btnn").click(function() {
				var arr=[];
				var arrid=[];
				$("input:checkbox[name='pay']:checked").each(function() {
				 var str= $(this).val();
				 arr.push(str.split("+")[0]);
				 arrid.push(str.split("+")[1]);
				});
				var count=0;
				for(var i=0;i<arr.length;i++){
				count+=parseInt(arr[i])
				}
				$("#countprice").attr("value",count)
			})
		})
	</script>
	
		<script type="text/javascript">
		$(function() {
			$("#sub").click(function() {
				var arrid=[];
				$("input:checkbox[name='pay']:checked").each(function() {
				 var str= $(this).val();
				 arrid.push(str.split("+")[1]);
				});
				var count="";
				for(var i=0;i<arrid.length;i++){
				count+=arrid[i]+" ";
				}
				if(count!==""){
					$.ajax({
						url:"payItems.action",
						data:{"itmid":count},
						dataType:"json",
						type:"post",
						success:function(data){
							if(data>0){
								var uid=$("input[name='user']").val();
								alert("提交成功!");
								window.location.href="showItem.action?uid="+uid;
							}
							
						}
					})
					
				}
				
			})
		})
	</script>
</body>
</html>
