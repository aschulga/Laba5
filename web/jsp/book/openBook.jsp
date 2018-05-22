<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Открыть книгу</title>
</head>
<body>
<c:import url="/jsp/user.jsp"/>

<form name="openBookForm" method="post" action="/controller">
    <input type="hidden" name="command" value="open_book"/>
    Номер книги<br>
    <input type="text" name="id_book" value=""/> <br><br>
    <input type="submit" value="Открыть"/>
</form>
</body>
</html>
