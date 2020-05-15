<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2020/5/6
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">

    <title>Title</title>
    <link href="static/css/app.css" rel="stylesheet">
    <script type="text/javascript" src="static/jquery/jquery-1.12.4.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){//绑定页面加载事件，在加载完后
            // alert("jsp文件加载完毕")
            $.ajax({//后台ajax请求
                url:"login",//请求路径
                type:"post",//请求方法
                contentType:"application/json",//请求的数据格式
                data:{username:"abc",password:"123"},
                dataType:"json",//响应的数据格式
                success:function (data){//返回状态码是200时，调用这个函数

                }
            });
            var json = {username:"abc",password: "123"}

            $("#btn").click(function () {
                alert("点击观看");
                //按钮点击请求服务代码
            });
        });

    </script>
</head>
<body>
<form action="login" method="post" enctype="application/x-www-form-urlencoded">
    用户名：<input type="text" name="username" placeholder="请输入用户名">
    密码：<input type="password" name="password" placeholder="请输入密码">
    <input type="submit" value="提交">
</form>
<input id="btn" type="button" value="点击观看">
</body>
</html>
