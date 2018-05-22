<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменить тему</title>
</head>
<body>
<c:import url="/jsp/user.jsp"/>

Измените тему <br><br>
<form name="replaceThemeForm" method="post" action="/controller">
    <input type="hidden" name="command" value="replace_theme"/>
    Номер <br>
    <input type="text" name="theme_id" value=""/> <br><br>
    Название<br>
    <input type="text" name="title" value=""/> <br><br>
    Содержание<br>
    <input type="text" name="content" value=""/> <br><br>
    <input type="submit" value="Изменить"/>
</form>
</body>
</html>
