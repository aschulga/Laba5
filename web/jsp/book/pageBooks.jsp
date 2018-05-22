<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Справочник</title>
</head>
<body>
<c:import url="/jsp/user.jsp"/>

<form name="showForm" method="post" action="/controller">
    <input type="hidden" name="command" value="show_table_of_books"/>
    <input type="submit" value="Посмотреть таблицу"/>
</form>

<form action="${pageContext.request.contextPath}/jsp/book/addBook.jsp">
    <input type="submit" value="Добавить книгу"/>
</form>

<form action="${pageContext.request.contextPath}/jsp/book/deleteBook.jsp">
    <input type="submit" value="Удалить книгу"/>
</form>

<form action="${pageContext.request.contextPath}/jsp/book/replaceBook.jsp">
    <input type="submit" value="Изменить книгу"/>
</form>

<form action="${pageContext.request.contextPath}/jsp/book/openBook.jsp">
    <input type="submit" value="Открыть книгу"/>
</form>

    <table border="3" align="center">
        <tr>
            <th>Номер</th>
            <th>Автор</th>
            <th>Название</th>
        </tr>

        <c:forEach var="bookList" items="${list}">
            <tr>
                <td>${bookList.id}</td>
                <td>${bookList.author.firstname} ${bookList.author.lastname}</td>
                <td>${bookList.title}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
