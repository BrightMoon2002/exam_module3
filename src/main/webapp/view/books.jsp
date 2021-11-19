
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
            <th>
                <form method="get">
                    <button name="action" type="submit" value="listBorrow">BorrowList</button>
                </form></th>
            <th>Mã Sách</th>
            <th>Tên Sách</th>
            <th>Tác giả</th>
            <th>Số lượng</th>
            <th>Mô tả</th>
        </tr>
        <c:forEach var="book" items="${bookList}">
            <tr>
                <td><c:out value="${book.getId()}"/></td>
                <td><c:out value="${book.getNameBook()}"/></td>
                <td><c:out value="${book.getAuthor()}"/></td>
                <td><c:out value="${book.getQuantity()}"/></td>
                <td><c:out value="${book.getDescription()}"/></td>
                <td>
                    <a href="/books?action=borrow&id=${book.getId()}">Mượn</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>