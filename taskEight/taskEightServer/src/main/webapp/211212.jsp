<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
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
    <form action="/register" method="post" th:onsubmit="'return sendIdentifyingCode();'">
        <div class="ui error message">
            <div class="header" id="error">请求正确填写注册信息哦!</div>
        </div>

        <div class="field">
            <input type="text" name="name" placeholder="独一无二的用户名">
        </div>

        <div class="field">
            <input type="text" name="phoneNumber" placeholder="手机号">
        </div>

        <div class="field">
            <input type="text" name="identifyingCode" placeholder="短信验证码">
            <button class="ui positive button msg" type="button" th:th:onclick="'getMsgNum(this)'">发送验证码</button>
        </div>

        <div class="field">
            <input type="text" name="pwd" placeholder="大于3位的密码,可由数字、字符、字母组成">
        </div>
        <button class="fluid teal ui button" type="submit">注册</button>
    </form>

    <script type="text/javascript">
        function sendIdentifyingCode() {
            var result = false;
            var data = {
                phoneNumber: $("input[name='phoneNumber']").val(),
                identifyingCode: $("input[name='identifyingCode']").val()
            };
            ajaxData("POST", "/sendIdentifyingCode", JSON.stringify(data), function (response) {
                console.log("result=" + response);
                if (!response) {
                    console.log("验证码错误");
                    $('.ui.form').form('add prompt', "identifyingCode", "验证码错误或超时");
                }
            });
            syncAjaxData("POST", "/sendIdentifyingCode", JSON.stringify(data), function (response) {
                console.log("result=" + response);
                if (response) {
                    result = true;
                }
            });
            return result;
        }
    </script>
</table>
</body>
</html>
