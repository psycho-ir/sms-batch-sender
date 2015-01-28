<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div style="font-size:14px; width: 100%; text-align: center;">
    <table style="width:100%;" border="1">
        <tr>
            <td>تیتر</td>
            <td>نام</td>
            <td>توضیحات</td>
            <td style="text-align: center;" colspan="2">عملیات</td>
        </tr>
        <c:forEach items="${roles}" var="phoneNumber">
            <tr>
                <td>${phoneNumber.title}</td>
                <td>${phoneNumber.name}</td>
                <td>${phoneNumber.description}</td>
                <td style="width:150px;">
                    <a href='<spring:url value="/upload/role/${phoneNumber.name}"/>'>بازگذاری مجدد شماره ها</a>
                </td>
                <td>
                    <a href='<spring:url value="/listPhone/${phoneNumber.name}"/>'>لیست شماره ها</a>
                </td>

            </tr>
        </c:forEach>
    </table>

</div>


