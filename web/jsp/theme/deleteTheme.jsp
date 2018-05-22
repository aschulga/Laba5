<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Удалить тему</title>
</head>
<body>
<c:import url="/jsp/user.jsp"/>

Удалите тему<br><br>
<form name="deleteThemeForm" method="post" action="/controller">
    <input type="hidden" name="command" value="delete_theme"/>
    Номер <br>
    <input type="text" name="id_theme" value=""/> <br><br>
    <input type="submit" value="Удалить"/>
</form>
</body>
</html>
