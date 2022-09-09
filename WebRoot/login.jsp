<%--
  Created by IntelliJ IDEA.
  User: cod01
  Date: 2022/5/26
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>WebScanner</title>
	<link rel="stylesheet" type="text/css" href="./css/sty.css" />

	</head>

	<body>
		<%
			if (session.getAttribute("loginError") != null) {
				session.removeAttribute("loginError");
		%>
		<script>
	
  		alert("用户名密码错误！")
  	</script>
		<%
			}
		%>
		
		<div class="center">
			<h1>Web漏洞扫描</h1>
      <form action="login" method="post">
<%--javabean类型传值--%>
		  <div class="inputbox">
			  <input type="text" required="required" name="userEntity.userName" >
			  <span>用户名</span>
		  </div>
		  <div class="inputbox">
			  <input type="password" required="required" name="userEntity.password" >
			  <span>密码</span>
		  </div>
		  <div class="inputbox">
			  <input type="submit" value="登录">
		  </div>
		  <div class="inputbox">
			  <input type="reset" value="重置" >
		  </div>
		  <div class="inputbox">
		     <input type=button value="注册" onclick="window.location.href='reg.jsp'">

		  </div>
<%--        <input type="text" name="userEntity.userName" placeholder="请输入用户名" class="txtb">--%>
<%--        <input type="password" name="userEntity.password" placeholder="请输入密码" class="txtb">--%>
<%--         <input type="submit" value="登录" class="signup-btn">--%>
<%--         <input type=button value="注册" class="signup-btn" onclick="window.location.href='reg.jsp'">      --%>
<%--        <a href="login.jsp">重置</a>--%>
      </form>
    </div>
  </body>
</html>