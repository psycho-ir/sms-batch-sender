<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  User: soroosh
  Date: 6/10/13
  Time: 10:24 AM
--%>
<div style="font-size:14px; width: 100%; text-align: center;">
    <table style="width:100%;" border="1">
        <tr>
            <td>نام</td>
            <td>نام خانوادگی</td>
            <td>شماره تماس</td>
            <td>وضعیت</td>
            <td>عملیات</td>
        </tr>
        <c:forEach items="${phoneNumbers}" var="phoneNumber">
            <tr>
                <td>${phoneNumber.name}</td>
                <td>${phoneNumber.lastName}</td>
                <td>${phoneNumber.phoneNumber}</td>
                <td>
                    <c:choose>
                        <c:when test="${phoneNumber.enable == false}">
                            غیر فعال

                        </c:when>
                        <c:otherwise>
                            فعال

                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <form method="post" action="<spring:url value='/remove' />">
                        <input type="hidden" name="role" value="${roleName}"/>
                        <input type="hidden" name="phoneNumber" value="${phoneNumber.phoneNumber}"/>
                        <input type="submit" value="حذف"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>