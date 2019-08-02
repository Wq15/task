<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%--    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
<%--    <title>page</title>--%>
<%--    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">--%>

<%--    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">--%>
<%--    <link href="css/dfghrgdffbdfb6base.css">--%>
<%--    <link href="css/Untitled-3.css" rel="stylesheet" type="text/css">--%>
<%--    <link href="css/Untitled-1base.css" rel="stylesheet" type="text/css">--%>

    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="text-align: center;margin: auto;">
<div id="header">
    <t:insertAttribute name="header"/>
</div>
<div id="content">
    <t:insertAttribute name="body"/>
</div>
<div id="footer">
    <t:insertAttribute name="footer"/>
</div>
</body>
</html>