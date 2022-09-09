<%--
  Created by IntelliJ IDEA.
  User: cod01
  Date: 2022/5/28
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" import="com.dhee.entity.UserEntity" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css"
          href="css/index.css"/>
</head>
<body>
<div class="main-container">
    <div class="heading">
        <h1 class="heading__title">WEB漏洞扫描</h1>
        <p class="heading__credits">
            <a class="heading__link" target="_blank" >
                    <%
                        if (session.getAttribute("userInfo") != null) {
                            UserEntity user = (UserEntity) session.getAttribute("userInfo");
                    %>
                    欢迎<%=user.getName() %>登录！
                    <%
                         }
                    %>
            </a>
        </p>
        <p class="heading__credits"><a class="heading__link" target="_blank" href="login.jsp">退出系统</a></p>
    </div>

    <div class="cards">
            <div>
                    <button type="button" onclick="window.location.href='index.jsp'" class="card card-1">
                        <h1 class="card__title">网络爬虫扫描</h1>
                    </button>
            </div>

            <div>

                    <button type="button" onclick="window.location.href='sql.jsp'" class="card card-2">
                        <h1 class="card__title">sql漏洞扫描</h1>
                    </button>

            </div>

            <div>

                    <button type="button" onclick="window.location.href='xss.jsp'"
                            class="card card-3">
                        <h1 class="card__title">XSS检测</h1>
                    </button>

            </div>

            <div>

                    <button type="button" onclick="window.location.href='getUrl'"
                            class="card card-4">
                        <h1 class="card__title">url管理</h1>
                    </button>

            </div>


        </div>

</div>
</body>
</html>