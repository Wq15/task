<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<table>
<body>
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

</body>
</table>
<a href="/user/page" ref="external nofollow">首页</a>
</html>
