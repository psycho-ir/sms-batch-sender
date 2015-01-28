<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form:form modelAttribute="uploadItem" enctype="multipart/form-data" method="post">
    <div style="font-size:14px; width: 100%; text-align: center;">
        فایل لیست شماره تماس ها را انتخاب کنید:
        <form:input path="fileData" type="file"></form:input>
        <br/>
        <form:input path="roleName" value="${roleName}" type="hidden"/>
        <input type="submit" value="بارگذاری">
    </div>

</form:form>
