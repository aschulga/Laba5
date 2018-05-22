<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Удалить книгу</title>
</head>
<body>
<c:import url="/jsp/user.jsp"/>

Удалите книгу<br><br>
<form name="deleteBookForm" method="post" action="/controller">
    <input type="hidden" name="command" value="delete_book"/>
    Номер <br>
    <input type="text" name="id_book" value=""/> <br><br>
    <input type="submit" value="Удалить"/>
</form>
</body>
</html>
