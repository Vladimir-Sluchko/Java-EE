<%@ page contentType="text/html;charset=UTF-8"
         language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Отправить сообщение</title>
</head>

<body>

<h3>Написать сообщение</h3>

<c:if test="${messageWrongUser == true}">
    <p style="color: red">Пользователя с таким логином нет!</p>
</c:if>

<form action="${pageContext.request.contextPath}/api/message" method="post">
    <p><b>Получатель </b><input type="text" placeholder="Логин получателя" name="recipientLogin"></p>
    <p><b>Текст </b><input type="text" placeholder="Текст сообщения" name="textMessage"></p>
    <p><input type="submit" value="Отправить"></p>
</form>

<p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui'" value="На главную"></p>

</body>
</html>