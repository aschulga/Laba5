<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить книгу</title>
</head>
<body>
<c:import url="/jsp/user.jsp"/>

Добавьте книгу <br><br>
<form name="addBookForm" method="post" action="/controller">
    <input type="hidden" name="command" value="add_book"/>
    Имя автора<br>
    <input type="text" name="firstname" value=""/> <br><br>
    Фамилия автора<br>
    <input type="text" name="lastname" value=""/> <br><br>
    Название книги<br>
    <input type="text" name="title" value=""/> <br><br>
    <input type="submit" value="Добавить"/>
</form>

</body>
</html>
