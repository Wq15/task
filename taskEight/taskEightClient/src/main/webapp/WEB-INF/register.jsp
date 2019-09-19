<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@page isELIgnored="false" %>
<%--<meta http-equiv="Content-Type" content="text/html charset=gb2312">--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<a href="/addMail" ref="external nofollow">我要使用邮箱注册</a>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script charset="utf-8" language="javascript" type="text/javascript" src="JS/CommonFields/common.js"></script>
    <title>Insert title here</title>
    <script src="<%=basePath %>/js/jquery-2.1.1.min.js"></script>
    <script src="<%=basePath %>/js/register.js?v=1.0.0"></script>
    <%--    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>--%>
    <script>
        function getBasePath() {
            return '<%=basePath%>';
        }

    </script>
</head>
<body>
<form>
    <div>
        账号: <input name="name">
    </div>
    <div>
        密码: <input name="pwd">
    </div>
    <div>
        手机号: <input name="phoneNumber">
    </div>
    <div>
        验证码: <input name="identifyingCode">
        <button type="button" class="sendVerifyCode">获取短信验证码</button>
    </div>
    <div>
        <button type="button" class="sub-btn">提交</button>
    </div>

</form>

<script type="text/javascript">
    $(function () {
        //发送验证码
        $(".sendVerifyCode").on("click", function () {
            var phoneNumber = $("input[name=phoneNumber]").val();
            $.ajax({
                url: getBasePath() + "/sendSms",
                async: true,
                type: "post",
                dataType: "json",
                data: {"phoneNumber": phoneNumber},
                success: function (data) {
                    if (data == 'fail') {
                        aert("发送 验证码失败");
                        return;
                    }
                }
            });
        })
        //提交
        $(".sub-btn").on("click", function () {
            var data = {};
            data.name = $.trim($("input[name=name]").val());
            data.pwd = $.trim($("input[name=pwd]").val());
            data.phoneNumber = $.trim($("input[name=phoneNumber]").val());
            data.identifyingCode = $.trim($("input[name=identifyingCode]").val());
            $.ajax({
                url: getBasePath() + "/register",
                async: true,
                type: "post",
                dataType: "json",
                data: data,
                success: function (data) {
                    if (data == 'fail') {
                        alert("注册失败");
                        return;
                    }
                    alert("注册成功");
                }
            });
        })
    });
</script>

</body>
</html>