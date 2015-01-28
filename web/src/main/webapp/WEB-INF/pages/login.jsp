<%--
  Created by IntelliJ IDEA.
  User: payam
  Date: 1/15/13
  Time: 11:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<spring:url value="/" var="login_url"/>
<spring:url value="/resources/javascript/jquery-1.7.1.js" var="jquery_url"/>
<spring:url value="/resources/css/login.css" var="style"/>
<spring:url value="/resources/images/Logo.png" var="logo"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" media="screen" href="${style}"/>
<style>
    .errorblock {
        color: #ff0000;
        background-color: #ffEEEE;
        border: 1px solid #ff0000;
        padding: 8px;
        margin: 16px;
        font-family: tahoma;
        font-size: 10px;
        text-align: right;
        width:200px;
    }
</style>

<div id="container" style="background-repeat: no-repeat">
    <form name='f' action="<c:url value='j_spring_security_check' />"
          method='POST'>

        <h1><img src="${logo}"/> <span>${title}</span></h1>
        <div class="form">
            <table>
                <tr>
                    <td>

                        <input type='text' name='j_username' value=''>
                    </td>
                    <td>
                        نام کاربری
                    </td>
                </tr>
                <tr>
                    <td>

                        <input type='password' name='j_password' />

                    </td>
                    <td>
                        کلمه عبور </td>
                </tr>
                <tr>
                    <td colspan="3"><c:if test="${not empty error}">
                        <div class="errorblock">

                            نام کاربری یا کلمه عبور صحیح نمی باشد
                        </div>
                    </c:if></td>
                </tr>
                <tr>
                    <td><input name="submit" type="submit" value="ورود"/></td>
                </tr>

            </table>
        </div>

    </form>
</div>

