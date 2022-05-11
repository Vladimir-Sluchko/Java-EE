<%@ page contentType="text/html;charset=UTF-8"
         language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<html>
<head>
    <h3>Информация об аэропортах</h3>
</head>
<body>
    <div>
        <p>Отсортируйте по городу:
            <form action="${pageContext.request.contextPath}/airports" method="get">
                <select name="sort">
                    <option value="">Выберите тип сортировки</option>
                    <option value="ASC">по алфавиту</option>
                    <option value="DESC">в обратном порядке</option>
                </select>
                <input type="submit" value="Отсортировать"/>
            </form>
        </p>
    </div>
    <div>
        <table class="table table-hover">
            <tr>
                <th>Код аэропорта</th>
                <th>Название аэропорта</th>
                <th>Город</th>
                <th>Координаты</th>
                <th>Timezone</th>
            </tr>
            <c:forEach var="airport" items="${requestScope.airportList}">
                <tr>
                    <td>${airport.airportCode}</td>
                    <td>${airport.airportName}</td>
                    <td>${airport.city}</td>
                    <td>${airport.coordinate}</td>
                    <td>${airport.timezone}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>




