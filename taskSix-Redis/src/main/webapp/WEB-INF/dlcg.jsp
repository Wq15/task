<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>登陆成功</title>
</head>

登入成功!
<br>
<br>
您好!${status}
<br>
<a href="/" rel="external nofollow" >返回</a>
<a href="/home" ref="external nofollow">首页</a>
<a href="/u/profession" ref="external nofollow">职业</a>
</html>