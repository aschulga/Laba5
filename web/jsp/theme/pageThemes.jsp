<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Книга</title>
</head>

<body>
<c:import url="/jsp/user.jsp"/>

<form name="showForm" method="post" action="/controller">
    <input type="hidden" name="command" value="show_table_of_themes"/>
    <input type="submit" value="Посмотреть таблицу"/>
</form>

<form action="${pageContext.request.contextPath}/jsp/theme/addTheme.jsp">
    <input type="submit" value="Добавить тему"/>
</form>

<form action="${pageContext.request.contextPath}/jsp/theme/deleteTheme.jsp">
    <input type="submit" value="Удалить тему"/>
</form>

<form action="${pageContext.request.contextPath}/jsp/theme/replaceTheme.jsp">
    <input type="submit" value="Изменить тему"/>
</form>

<form action="${pageContext.request.contextPath}/jsp/book/pageBooks.jsp">
    <input type="submit" value="Вернуться к списку книг"/>
</form>

<table border="3" align="center">
    <tr>
        <th>Номер</th>
        <th>Название</th>
        <th>Содержание</th>
    </tr>

    <c:forEach var="themeList" items="${list}">
        <tr>
            <td>${themeList.id}</td>
            <td>${themeList.title}</td>
            <td>${themeList.content}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
