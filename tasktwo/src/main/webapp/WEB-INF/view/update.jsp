<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@page isELIgnored="false" %>
<%--<meta http-equiv="Content-Type" content="text/html charset=gb2312">--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改</title>
</head>
<body>
<table>
    <form action="/user/update" method="POST" accept-charset="UTF-8" onsubmit="document.charset='UTF-8'">
        <tr>
            <td>序列:</td>
            <td><input type="int" name="id" value="${studentone.id}"/></td>

        </tr>
        <tr>
            <td>姓名:</td>
            <td><input type="text" name="name" value="${studentone.name}"/></td>
        </tr>
        <tr>
            <td>qq:</td>
            <td><input type="int" name="qq" value="${studentone.qq}"/></td>
        </tr>
        <tr>
            <td>修真类型:</td>
            <td><input type="text" name="typesOfCorrection" value="${studentone.typesOfCorrection}"/></td>
        </tr>
        <tr>
            <td>入学日期:</td>
            <td><input type="text" name="admissionDate" value="${studentone.typesOfCorrection}"/></td>
        </tr>
        <tr>
            <td>毕业学校:</td>
            <td><input type="text" name="graduateSchool" value="${studentone.graduateSchool}"/></td>
        </tr>
        <tr>
            <td>学号:</td>
            <td><input type="int" name="studentId" value="${studentone.studentId}"/></td>
        </tr>
        <tr>
            <td>日报链接:</td>
            <td><input type="text" name="dailyLink" value="${studentone.dailyLink}"/></td>
        </tr>
        <tr>
            <td>师兄:</td>
            <td><input type="text" name="mentorBrother" value="${studentone.mentorBrother}"/></td>
        </tr>
        <tr>
            <td>宣誓:</td>
            <td><input type="text" name="oath" value="${studentone.oath}"/></td>
        </tr>


        <tr>
            <td><input type="submit" value="确定"/></td>
        </tr>
    </form>
</table>
</body>
</html>