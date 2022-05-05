<%@ page contentType="text/html;charset=UTF-8"
         language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h3>Информация об аэропортах</h3>



<html>
<body>
 <p>Отсортируйте по городу:
 <form action="airports" method="post">
    <select name="sort" method="post">
        <option value="ASC">по алфавиту</option>
        <option value="DESC">в обратном порядке</option>
    </select>
    <input type="submit" value="Отсортировать"/></p></br> </br>
 </form>


<table border="4" bordercolor="#000000" cellspacing="1" cellpadding="10">
  <tbody>
    <tr>
      <th>Код аэропорта</th>
      <th>Название аэропорта</th>
      <th>Город</th>
      <th>Координаты</th>
      <th>Timezone</th>
    </tr>
    <c:forEach var="airport" items="${airportList}">
    <tr>
          <td>"${airport.airportCode}"</td>
          <td>"${airport.airportName}"</td>
          <td>"${airport.city}"</td>
          <td>"${airport.coordinate}"</td>
          <td>"${airport.timezone}"</td>
        </tr>
    </c:forEach>

  </tbody>
</table>
</body>
</html>




