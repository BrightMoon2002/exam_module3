<%--
  Created by IntelliJ IDEA.
  User: duynguyen
  Date: 19/11/2021
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Return</title>
</head>
<body>
<form method="post">
    <table border="1" cellpadding="5">
        <tr>
            <th>Mã mượn sách :</th>
            <td>
                <input type="text" name="mms" size="45" value="MS-XXX"/>
            </td>
        </tr>
        <input type="hidden" name="idBook" size="45" value="${book.getId()}"/>
        <tr>
            <th>Tên sách</th>
            <td>
                <input type="text" name="nameBook" size="45" value="${book.getNameBook()}"/>
            </td>
        </tr>
        <tr>
            <th>Ngày mượn sách</th>
            <td>

                <input type="date" name="borrowDate" size="15" value="${BorrowDate}"/>
            </td>
        </tr>
        <tr>
            <th>Ngày trả sách</th>
            <td>
                <input type="date" name="payDate" min="${BorrowDate}" max="2029-04-30" size="15">
                <%--                    <input type="date" name="payDate" size="15"/>--%>
            </td>
        </tr>
        <tr>
            <th>Student:</th>
            <td>
                <input type="text" name="student" size="45" value="${student.fullName)}"/>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Return"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
