<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить тему</title>
</head>
<body>
<c:import url="/jsp/user.jsp"/>

Добавьте тему <br><br>
<form name="addThemeForm" method="post" action="/controller">
    <input type="hidden" name="command" value="add_theme"/>
    Название<br>
    <input type="text" name="title" value=""/> <br><br>
    Содержание<br>
    <input type="text" name="content" value=""/> <br><br>
    <input type="submit" value="Добавить"/>
</form>
</body>
</html>
