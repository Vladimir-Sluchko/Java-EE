<%@ page contentType="text/html;charset=UTF-8"
         language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Статистика</title>
</head


<body>
<p>Колличество пользователей: <c:out value="${usersCount}"/></p>
<br>Колличество сообщений: <c:out value="${messagesCount}"/><br>
<br>Колличество сессий: <c:out value="${sessionsCount}"/><br>


<c:if test="${user != null}">
    <h3 style="color: green">Привет, <c:out value="${user.login}"/>!</h3>
    <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/user/message" value="Написать сообщение"></p>
    <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/user/chats'" value="Посмотреть сообщения"></p>
    <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/admin/statistics'" value="Статистика"></p>

</c:if>

</body>
</html>