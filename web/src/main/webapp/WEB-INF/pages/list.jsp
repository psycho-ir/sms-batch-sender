<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  User: soroosh
  Date: 6/2/13
  Time: 12:03 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<spring:url value="/run" var="run_url"></spring:url>

<form:form modelAttribute="messageJob" action="${run_url}">
    <table>
        <tr>
            <td>
نقش های مورد نظر
            </td>
            <td>
                <form:checkboxes path="excelFiles" items="${roles}" itemValue="name" itemLabel="title"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <form:checkbox path="filtered" label="فیلتر شماره ها" ></form:checkbox>
            </td>

            <td></td>
        </tr>
        <tr>
            <td  style="vertical-align:top;" >متن پیام</td>
            <td>
                <form:textarea style="direction:rtl;text-align:right;width:600px;height:200px;"
                               path="message"></form:textarea>

            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="ارسال">
            </td>
        </tr>
    </table>
</form:form>
