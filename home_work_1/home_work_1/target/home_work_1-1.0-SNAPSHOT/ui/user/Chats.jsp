<%@ page contentType="text/html;charset=UTF-8"
         language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>


<h3>Входящие сообщения!</h3>
<p>

        <c:choose>
            <c:when test="${messages.size() > 0}">
                Ваши сообщения:<br>
                <c:forEach var="message" items="${messages}">
                    <li style="color:red"><c:out value="${message}"/></li>
                </c:forEach>
            </c:when>
            <c:otherwise>
                У вас нет сообщений.
            </c:otherwise>
        </c:choose>
</p>

