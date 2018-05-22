<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="float: right">
    ${pageContext.session.getAttribute("userName")}
    <form name="logOutForm" method="post" action="/authorization">
        <input type="hidden" name="command" value="logout"/>
        <input type="submit" value="Logout"/>
    </form>
</div>