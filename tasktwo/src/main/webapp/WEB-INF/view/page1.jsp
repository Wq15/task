<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--<%@page isELIgnored="false" %>--%>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.text.DateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <style>
        th, tr, td, table {
            border:1px solid #060402
        }
    </style>
</head>
<body>
<table>
    <tr>
        <td>序列:</td>
        <td><input type="int" name="id"/>
            <a href="/user/delect" rel="external nofollow" >查询</a></td>

        <td><a href="/user/add" rel="external nofollow" >添加</a></td>
    </tr>
    <tr>
        <th>序列</th>
        <th>姓名</th>
        <th>qq</th>
        <th>修真类型</th>
        <th>入学日期</th>
        <th>毕业学校</th>
        <th>学号</th>
        <th>日报链接</th>
        <th>师兄</th>
        <th>oath</th>
        <th>修改</th>
        <th>删除</th>
    </tr>
    <c:forEach items="${user}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.qq}</td>
            <td>${user.typesOfCorrection}</td>
            <td>${user.admissionDate}</td>
            <td>${user.graduateSchool}</td>
            <td>${user.studentId}</td>
            <td>${user.dailyLink}</td>
            <td>${user.mentorBrother}</td>
            <td>${user.oath}</td>

            <td><a href="/user/updateone/${user.id}" rel="external nofollow" >修改</a></td>
            <td>
                <form action="/user/delete/${user.id}" method="POST">

                    <input type="hidden" name="_method" value="DELETE" >

                    <input type="submit" name="submit" value="删除"/>
                </form>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>

