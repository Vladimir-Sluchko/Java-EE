<%@ page contentType="text/html;charset=UTF-8"
         language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>SignIn</title>
</head


<body>
<c:if test="${messageUserNoCreated == true}">
    <p style="color: red">Неправильный логин! Пользоватаеля с таким логином не существует!</p>
</c:if>

<c:if test="${messageIncorrectPassword == true}">
    <p style="color: red">Неверный пароль</p>
</c:if>

<form action="${pageContext.request.contextPath}/api/login" method="post">
    <p><b>Логин</b> <input type="text" placeholder="Логин пользователя" name="login"></p>
    <p><b>Пароль</b> <input type="password" placeholder="Пароль" name="password"></p>
    <p><input type="submit" value="Войти"></p>
    <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui'" value="На главную"></p>
    </form>

</body>
</html>

