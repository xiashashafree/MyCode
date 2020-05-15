<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2020/5/11
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
    <!-- 引用样式文件-->
    <link href="static/css/app.css" rel="stylesheet">
    <!-- jQuery -->
    <script type="text/javascript" src="static/jquery/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" >
          <!--html文档加载完毕之后执行的操作-->
        $(document).ready(function(){//绑定页面加载事件，在加载完后执行
            // alert("jsp文件加载完毕")
            $.ajax({//提交后台ajax请求
                url:"login",
                type:"post",
                contentType:"application/json",//请求数据格式
                <!--json数据格式-->
                data:{
                    username:"abc",password:"123"},
                dataType:"json",//响应的数据格式
                success:function (data) {//返回的状态码是200时，调用这个哈数

                }
            });
            var json = { username:"abc",password:"123"};
            alert(json.username);
            $("#btn").click(function () {//绑定按钮的点击事件
                // alert("点击按钮")
            })
        });
    </script>
</head>
<body>
    <!--假如，提交到后台的url是http://localhost:8080/blogdemo/login -->
    <!-- action = "login"  现在访问到的页面是：http://localhost:8080/blogdemo/jsp/login，
    是以当前页面为相对路径    action = "/login" 现在访问到的是--http://localhost:8080/login -->
    <!-- 配置jsp变量及base标签 可以解决路径问题 ：action="login"，访问的就是正确路径 -->
    <form action = "login">
        <input type = "text" name="username" placeholder="请输入用户名">
        <input type = "password" name="password" placeholder="请输入密码">
        <input type = "submit" value = "提交">

    </form>
    <input id="btn" type="button" value="点击观看事件">
</body>
</html>
