<%@ page contentType="text/html;charset=UTF-8"
         language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Форма регистрации</title>
</head>
<body>
<c:if test="${userCreated == true}">
    <p style="color: red">Пользователь с таким логином уже существует!</p>
</c:if>

<c:if test="${messageOfEmpty == true}">
    <p style="color: red">Заполните все поля формы регистрации!</p>
</c:if>

<form action="${pageContext.request.contextPath}/api/user" method="post">
    <p><b>Логин</b> <input type="text" placeholder="Логин пользователя" name="login"></p>
    <p><b>Пароль</b> <input type="password" placeholder="Пароль" name="password"></p>
    <p><b>ФИО</b> <input type="text" placeholder="ФИО пользователя" name="fullName"></p>
    <p><b>Дата рождения</b> <input type="date", placeholder="Дата рождения" name="dateOfBirth"></p>
    <p><input type="submit" value="Зарегистрироваться"></p>
    <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui'" value="На главную"></p>
</form>

</body>
</html>