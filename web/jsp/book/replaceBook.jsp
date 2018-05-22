<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменить книгу</title>
</head>
<body>
<c:import url="/jsp/user.jsp"/>

Измените книгу <br><br>
<form name="replaceBookForm" method="post" action="/controller">
    <input type="hidden" name="command" value="replace_book"/>
    Номер <br>
    <input type="text" name="book_id" value=""/> <br><br>
    Имя автора<br>
    <input type="text" name="firstname" value=""/> <br><br>
    Фамилия автора<br>
    <input type="text" name="lastname" value=""/> <br><br>
    Название книги<br>
    <input type="text" name="title" value=""/> <br><br>
    <input type="submit" value="Изменить"/>
</form>
</body>
</html>
