<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@page isELIgnored="false" %>
<%--<meta http-equiv="Content-Type" content="text/html charset=gb2312">--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册</title>
</head>
<body>
<table>
    <form action="/register" method="post" accept-charset="UTF-8" onsubmit="document.charset='UTF-8'">

            <tr>
                 <td>用户名:</td>
                 <td><input type="text" name="name"/></td>
            </tr>

            <tr>
                <td>密码:</td>
                <td><input type="text" name="pwd"/></td>
            </tr>

            <tr>

                <td><input type="submit" value="确定"/></td>
            </tr>

            <tr><td>
                <a href="/index.jsp" rel="external nofollow" >返回</a>
            </td>
            </tr>

    </form>
</table>
</body>
</html>