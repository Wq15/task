<%@ page import="com.auth0.jwt.interfaces.Claim" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.pojo.JwtTokenUtil" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="dateValue" class="java.util.Date"/>
<!-- 通过jsp:userBean标签引入java.util.Date日期类 -->


<%
    Cookie[] cookies = request.getCookies();
    String token = null;
    String ss = null;

    if (cookies != null) {
        for (Cookie cook : cookies) {

            if (cook.getName().equals("token")) {
                token = cook.getValue();

                Map<String, Claim> verifyToken = JwtTokenUtil.verifyToken(token);

                ss = verifyToken.get("username").asString();

                System.out.println(ss);

            }

        }
    }
%>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>无标题文档</title>
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="../css/dfghrgdffbdfb6base.css">
<link href="../css/Untitled-3.css" rel="stylesheet" type="text/css">
<link href="../css/Untitled-1base.css" rel="stylesheet" type="text/css">
<link href="../css/t11.css" rel="stylesheet" type="text/css">


<div class="container  hidden-xs">
    <div class="row header-top">
        <p class="col-xs-12 col-sm-6 col-md-6 col-lg-6">客服电话:010-594-78634 系统时间：<fmt:formatDate value="${dateValue}"
                                                                                                pattern="yyyy-MM-dd HH:mm:ss"/>
            <!-- 转换格式 --></p>
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 text-right">
            <div>
                <a href="#" target="_blank"> <img alt="" src="../imges/54537.png"></a>
                <a href="#" target="_blank"><img alt="" src="../imges/45678678.png"></a>
                <a href="#" target="_blank"> <img alt="" src="../imges/54375483543.png"></a>
            </div>
        </div>
    </div>
</div>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">
                <img src="../imges/logo.png" alt="Brand" class="img-responsive">
            </a>
            <button data-target="#open-nav" data-toggle="collapse" class="navbar-toggle btn-primary collapsed"
                    aria-expanded="false">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div id="open-nav" class="navbar-collapse collapse" aria-expanded="false" style="height: 1px;">
            <ul class="nav navbar-nav navbar-right text-center list-inline">
                <li><a href="/home">首页</a></li>
                <li><a href="/u/profession">职业</a></li>
                <li><a href="">推荐</a></li>
                <li><a href="">关于</a></li>
                <c:if test="${cookie['token'].value eq null}">
                    <a href="/">
                        <li>登 录</li>
                    </a>
                    <a href="/add">
                        <li>注 册</li>
                    </a>
                </c:if>


                <c:if test="${cookie['token'].value ne null}">
                    <a href="/signout">
                        <li><%=ss%>|注 销</li>
                    </a>
                </c:if>
            </ul>
        </div>

    </div>
</nav>
