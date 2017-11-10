<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<body>

<h2>Hello World!</h2>


<table border="1" width="100%">
    <tr>
        <td>用户名</td>
        <td>密码</td>
        <td>操作</td>
    </tr>

    <c:forEach items="${requestScope.users}" var="user">

        <form name="myform" action="modifyUser" method="post" modelAttribute="user">

            <tr>
                <td><input type="text" name="id" value="${user.id}"/></td>
                <td><input type="text" name="name" value="${user.name}"/></td>
                <td><input type="text" name="password" value="${user.password}"/></td>
                <td><input type="submit" value="修改"/></td>

            </tr>
        </form>

    </c:forEach>


    <form name="myform" action="addUser" method="post" modelAttribute="user">
        <tr>
            <td></td>
            <td><input type="text" name="name" value=""/></td>
            <td><input type="text" name="password" value=""/></td>
            <td><input type="submit" value="add"/></td>
        </tr>
    </form>

</table>


</body>
</html>

