<%--
  Created by IntelliJ IDEA.
  User: cod01
  Date: 2022/6/6
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	import="com.dhee.entity.UserEntity,com.dhee.entity.URLEntity"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>url管理 ' starting page</title>

	   <link rel="stylesheet" type="text/css" href="./css/table.css">
		<link rel="stylesheet" type="text/css" href="./css/button.css">

		<script type="text/javascript">
		function del(id){
			if(confirm("确定删除吗？")){
				location.href="delUrl?urlId="+id;
			}
		}

		function output(){
			location.href="getFile";
		}

		</script>
	</head>

	<body>
	<%
		if(session.getAttribute("report")!=null){//abc
			Boolean b = (Boolean) session.getAttribute("report");
			if(b){//
				%>
				<script type="text/javascript">alert("生成报告成功！");</script>
				<%
			}else{
				%>
				<script type="text/javascript">alert("生成报告失败！");</script>
				<%
			}
		}
	
	%>

			<h2>web漏洞扫描</h2>
			<%
				if (session.getAttribute("userInfo") != null) {
					UserEntity user = (UserEntity) session.getAttribute("userInfo");
			%>
			<h2>
				欢迎<%=user.getName()%>登录！
			</h2>
	<%
		}
	%>
	<div style="margin: 0 auto;">
			<a href="index.jsp" style=" margin: auto;"><button class="bn632-hover bn26">爬虫</button></a>
			<a href="sql.jsp" style=" margin: auto;"><button class="bn632-hover bn26">SQL注入</button></a>
		<a href="xss.jsp" style=" margin: auto;"><button class="bn632-hover bn26">XSS检测</button></a>
		<a href="logout" style=" margin: auto;"><button class="bn632-hover bn26">退出</button></a>
		<button class="bn632-hover bn26" onclick="output()" >生成报告</button>

	</div>

	<div class="table-wrapper">
			<table class="fl-table">
				<thead>
				<tr>
					<th>URL</th>
					<th>sql注入</th>
					<th>XSS漏洞</th>
					<th>操作</th>
				</tr>
				</thead>
				<tbody>
				<%
					if (session.getAttribute("urlList")!=null) {
						List<URLEntity> urlList = (List<URLEntity>) session.getAttribute("urlList");
						for(URLEntity url: urlList){
				%>

				<tr>
					<td>
						<%=url.getUrl() %>
					</td>
					<td>
						<%
							if("1".equals(url.getSql())){
						%>
						存在注入点
						<%} %>
						<%
							if("2".equals(url.getSql())){
						%>
						不存在注入点
						<%} %>
						<%
							if("0".equals(url.getSql())){
						%>
						未检测
						<%} %>
					</td>


					<td>
						<%
							if("1".equals(url.getXss())){
						%>
						存在注入点
						<%} %>
						<%
							if("2".equals(url.getXss())){
						%>
						不存在注入点
						<%} %>
						<%
							if("0".equals(url.getXss())){
						%>
						未检测
						<%} %>
					</td>


					<td>

						<input type="button" value="删除" onclick="del('<%=url.getId() %>')" />
					</td>
				</tr>

				<%
						}}
				%>



				</tbody>
			</table>
	</div>
	</body>
</html>

