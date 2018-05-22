<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>

<form name="openSiteVkForm" method="get" action="/authorization">
    <input type="hidden" name="command" value="site_vk"/>
    <input type="submit" value="VK"/>
</form>

<form name="openSiteGitHubForm" method="post" action="/authorization">
    <input type="hidden" name="command" value="site_github"/>
    <input type="submit" value="GitHub"/>
</form>

</body>
</html>
