<%--
  Created by IntelliJ IDEA.
  User: cod01
  Date: 2022/5/31
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8" import="com.dhee.entity.UserEntity" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>table</title>
    <link rel="stylesheet" type="text/css" href="./css/spider.css">
</head>

<body>
<div class="container right-panel-active">
    <!-- Sign Up -->
    <div class="container__form container--signup">
        <form action="scan" class="form" id="form1" method="post" name="">
            <h2 class="form__title">爬虫扫描</h2>
            <input name="urlEntity.url" type="text" class="input" placeholder="请输入url地址"/>
            <input name="submit" class="btn" type="submit" value="扫描" />
        </form>
        扫描结果
        <select size="20" id="urlResult" style="width: 450px">

            <%
                if(session.getAttribute("enableUrl") != null){
                    List<String> enableUrl = (List<String>)session.getAttribute("enableUrl");
                    for(String url : enableUrl){
            %>
            <option value="<%=url %>"><%=url %></option>
            <%

                    }
                }
            %>

        </select>

    </div>



    <!-- Overlay -->
    <div class="container__overlay">
        <div class="overlay">
            <div class="overlay__panel overlay--left">
                <h2 style="color:white"><%
                    if (session.getAttribute("userInfo") != null) {
                        UserEntity user = (UserEntity) session.getAttribute("userInfo");
                %>
                    <div>欢迎<%=user.getName() %>登录！</div>
                    <%
                        }

                    %></h2>
                <a class="btn" href="sql.jsp" style="
                            border-bottom-width: 1px;
                            margin-bottom: 10px;
                        ">sql注入</a>
                <a class="btn" href="xss.jsp" style="
                            border-bottom-width: 1px;
                            margin-bottom: 10px;
                        ">XSS检测 </a>
                <a class="btn" href="getUrl" style="
                        border-bottom-width: 1px;
                        margin-bottom: 10px;
                    ">url管理</a>
                <a class="btn" href="login.jsp" style="
                        border-bottom-width: 1px;
                        margin-bottom: 10px;
                    ">退出系统</a>
            </div>

        </div>
    </div>
</div>
</body>

</html>