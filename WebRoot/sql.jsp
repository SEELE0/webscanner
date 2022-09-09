<%--
  Created by IntelliJ IDEA.
  User: cod01
  Date: 2022/6/4
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8" import="com.dhee.entity.UserEntity" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>table</title>
    <link rel="stylesheet" type="text/css" href="./css/sql.css">
</head>

<body>
<div class="container right-panel-active">
    <!-- Sign Up -->
    <div class="container__form container--signup">
        <form action="sqlInjection" class="form" id="form1" method="post" name="">
            <h2 class="form__title">SQL注入漏洞检测</h2>
<%--            javabean方式传数据--%>
            <input name="urlEntity.url" type="text" class="input" placeholder="请输入url地址"/>
            <input name="submit" class="btn" type="submit" value="开始检测" />
        </form>
        <%
            if(session.getAttribute("sqlInject")!=null){  //取名为sqlInject的session会话在Action类中设置
                Boolean b  = (Boolean)session.getAttribute("sqlInject");
                if(b){
        %>
        <script>
            alert("url存在Sql注入！");

        </script>
        <%
        }else{
        %>
        <script>
            alert("url不存在Sql注入！");

        </script>
        <%
                }
                session.removeAttribute("sqlInject");
            }

        %>

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
                <a class="btn" href="index.jsp" style="
                            border-bottom-width: 1px;
                            margin-bottom: 10px;
                        ">网络爬虫</a>
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