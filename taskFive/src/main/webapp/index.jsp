<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title></title>
</head>
<body>
<br>
<br>
<form name="form1" action="/login" method="post" >
    <table width="300" border="1" align="center">
        <tr>
            <td colspan="2">登入窗口</td>
        </tr>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="name">
            </td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="pwd"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="submit" value="登录"/>
                <a href="/add" ref="external nofollow">注册</a>
            </td>
        </tr>

    </table>
</form>

</body>
</html>
