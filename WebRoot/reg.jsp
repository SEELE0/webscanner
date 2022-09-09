<%--
  Created by IntelliJ IDEA.
  User: cod01
  Date: 2022/5/27
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

		<title>reg</title>
		<link rel="stylesheet" type="text/css"
			href="css/sty.css" />

	</head>

	<body>
	  <%
			if (session.getAttribute("regError") != null) {
				session.removeAttribute("regError");
		%>
		<script>

  		alert("用户名不能重复！")
  	</script>
		<%
			}
		%>
	  <div class="center">
		  <h1>注册</h1>
		  <form action="registe" method="post">

			  <div class="inputbox">
				  <input type="text" required="required" name="userEntity.userName" >
				  <span>用户名</span>
			  </div>
			  <div class="inputbox">
				  <input type="password" required="required" name="userEntity.password" >
				  <span>密码</span>
			  </div>
			  <div class="inputbox">
				  <input type="name" required="required" name="userEntity.name" >
				  <span>姓名</span>
			  </div>
			  <div style="font-size:20px;border-bottom-width: 20px;padding-bottom: 30px">
				  性别：
				  <input type="radio" name="userEntity.sex" value="m" checked />男
				  <input type="radio" name="userEntity.sex" value="f" />女
			  </div>
			  <div class="inputbox">
				  <input type="submit" value="注册" />
			  </div>
			  <div class="inputbox">
				  <input type="reset" value="重置" />
			  </div>
			  <div class="inputbox">
				  <a href=login.jsp>退出</a>
			  </div>

		  </form>
	  </div>
	</body>
</html>