<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  User: soroosh
  Date: 6/2/13
  Time: 12:03 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<spring:url value="/filtered-run" var="run_url"></spring:url>

<form:form modelAttribute="filteredMessageJob" action="${run_url}">

    <table style="width:100%;" border="1">
        <tr>
            <td><input type="checkbox" id="chkall"/></td>
            <td>نام</td>
            <td>نام خانوادگی</td>
            <td>شماره تماس</td>
            <td>وضعیت</td>
        </tr>
        <c:forEach items="${phoneNumbers}" var="phoneNumber">
            <tr>
                <td><form:checkbox path="phoneNumbers" value="${phoneNumber.phoneNumber}"></form:checkbox></td>
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
            </tr>
        </c:forEach>
        <form:hidden path="message" value="${message}"></form:hidden>
        <tr>
            <td colspan="6">
                <form:button value="ارسال">ارسال</form:button>
            </td>
        </tr>
    </table>


</form:form>
<script type="text/javascript">

    $(document).ready(function () {
        $('#chkall').click(function () {
            var value = $('#chkall').attr('checked') ? true : false;
            changeAll(value)
        });
    });
    function changeAll(value) {
        $('input[type=checkbox]').each(function () {
                    if (this.id != 'chkall') {
                        this.checked = value;
                    }
                }
        );
    }

</script>
