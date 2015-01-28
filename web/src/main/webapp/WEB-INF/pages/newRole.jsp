<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form:form modelAttribute="role" enctype="multipart/form-data" method="post">
    <div style="font-size:14px; width: 100%; text-align: center;">
        <table>
            <tr>
                <td>
                    تیتر:&nbsp;

                </td>
                <td>
                    <form:input path="title" type="text"/>
                </td>
            </tr>
            <tr>
                <td>
                    نام:&nbsp;
                </td>
                <td>
                    <form:input path="name" type="text"/>

                </td>
            </tr>
            <tr>
                <td>
                    توضیحات:&nbsp;
                </td>
                <td>
                    <form:textarea path="description"/>

                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="ذخیره"/>
                </td>

            </tr>
        </table>
    </div>

</form:form>
