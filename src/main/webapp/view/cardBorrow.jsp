<%--
  Created by IntelliJ IDEA.
  User: duynguyen
  Date: 19/11/2021
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List Book</h2></caption>
        <tr>
            <th>Code</th>
            <th>id Student</th>
            <th>status</th>
            <th>Ngày mượn</th>
            <th>Ngày trả</th>
        </tr>
        <c:forEach var="b" items="${borrowList}">
            <tr>
                <td>${b.getIdBookCard()}</td>
                <td>${b.getIdStudent()}</td>
                <td>${b.isStatus()}</td>
                <td>${b.getBorrowDate()}</td>
                <td>${b.getReturnDate()}</td>
                <td>
                    <a href="/books?action=return&id=${b.getIdBookCard()}">
                       Return</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</body>
</html>
