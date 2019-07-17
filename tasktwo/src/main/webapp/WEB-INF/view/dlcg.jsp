<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>好吧 就这样</title>
</head>

登入成功!
<br>
<br>
您好!${user.username}
<br>
<a href="/index.jsp" rel="external nofollow" >返回</a>
<a href="/user/page" ref="external nofollow">首页</a>
</html>