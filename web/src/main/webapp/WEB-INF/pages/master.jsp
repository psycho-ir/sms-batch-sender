<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  User: soroosh
  Date: 6/2/13
  Time: 4:16 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<spring:url value="/" var="list_url"></spring:url>
<spring:url value="/role/list" var="role_list_url"></spring:url>
<spring:url value="/role/new" var="new_role_url"></spring:url>
<spring:url value="/logout" var="logout_url"></spring:url>
<spring:url value="/resources/css/style.css" var="style_1"/>
<spring:url value="/resources/css/jquery-ui-1.8.14.css" var="style"/>
<spring:url value="/resources/javascript/jquery-1.7.1.js" var="jquery_url"/>
<spring:url value="/resources/javascript/jquery.ui.datepicker-cc.all.min.js" var="jquery_ui_url"/>
<spring:url value="/resources/images/samen-header.jpg" var="logo"/>
<spring:url value="/resources/images/h_logo.png" var="h_logo"/>
<html xmlns="http://www.w3.org/1999/xhtml" lang="fa">
<%--<style>
    body {
        font-family: tahoma, verdana;
        font-size: 14px;
    }

    .header {
        text-align: center;
        background-color: #DEC7A4;
    }

    .menu {

        vertical-align: top;
        width: 210px;
        font-size: 14px;
        text-align: center;
        border: 1px solid #204164;
    }

    .content {

    }

    .wrapper {
        height: 250px;
        border-width: 0;
        width: 100%;
    }
</style>--%>
<html>
<head>
    <link rel="stylesheet" type="text/css" media="screen" href="${style}"/>
    <link rel="stylesheet" type="text/css" media="screen" href="${style_1}"/>
    <script type="text/javascript" src="${jquery_url}"></script>
    <script type="text/javascript" src="${jquery_ui_url}"></script>
    <style type="text/css">
        * {
            font-family: tahoma, verdana;
            font-size: 12px;
        }

        .errorblock {
            color: #ff0000;
            background-color: #ffEEEE;
            border: 1px solid #ff0000;
            padding: 8px;
            margin: 16px;
            font-size: 10px;
            text-align: right;
            width: 900px;
            direction: rtl;
        }

        body {
            background-color: #ebebeb;
        }

        #header-top-wrapper {
            background-color: #69726A;
        }

        #navigation-wrapper {
            background-color: #69726A;
        }

        #rich-header {
            background-color: #D4CFC7;
            background-image: url("${h_logo}");
            border-color: #D4CFC7;
            color: #000000;
            font-family: Arial, Verdana, sans-serif;
            font-size: 11px;

            height: 20px;
            text-align: center;

        }
    </style>
    <title>SAMENEA Batch Message Sender</title>
</head>
<body class="rtl home blog">
<div id="wrapper">
    <div id="header">
        <img src="${logo}"/>
    </div>
    <div id="navigation-wrapper">
        <div id="navigation">
            <div class="menu">
                <ul style="margin-top: 0px; margin-bottom: 0px; padding-right:0px;">
                    <li class="page_item page-item-55 current_page_item"><a href="${list_url}">ارسال پیامک</a></li>
                    <li class="page_item page-item-55 current_page_item"><a href="${role_list_url}">نقش ها</a></li>
                    <li class="page_item page-item-55 current_page_item"><a href="${new_role_url}">نقش جدید</a></li>
                    <li class="page_item page-item-55 current_page_item"><a href="${logout_url}">خروج</a></li>

                </ul>
            </div>
        </div>
    </div>
    <div style=" margin-bottom: 40px; margin-right:0px; direction: rtl; text-align:center; ">
        <tiles:insertAttribute name="body" ignore="true"/>
    </div>
</div>
<div id="footer-wrapper" style="background-color:#69726A;">
    <div id="footer" style="background-color:#69726A;">
    </div>
</div>
<div id="bottom-wrapper" style="background-color:#69726A;">
    <div id="bottom">
            <span class="left">کپی‌رایت © 2013
                - samen.ir تمامی حقوق محفوظ است.</span> <span class="right">

                    طراحی  و بهینه سازی توسط <a href="http://www.samenea.com/">شرکت ثامن ارتباط عصر </a>
                </span>
        <br>
    </div>
</div>
</body>
</html>