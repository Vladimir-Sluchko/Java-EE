<%@ page contentType="text/html;charset=UTF-8"
         language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h3>Поиск полета</h3>

<form action="flights" method="post">

    <p>
        Дата вылета
            <input type="date", placeholder="Дата влета" name="scheduledDeparture"></p>
    </p>
    <p>
        Аэропорт вылета
        <select name="departureAirport" id="2">
            <option disabled>Выберите аэропорт вылета</option>
            <option value=""></option>
            <c:forEach var="departureAirport" items="${departureAirportList}">
                <option value="${departureAirport}">${departureAirport}</option>
            </c:forEach>
        </select>
    </p>

    <p>
            Дата прилета
            <input type="date", placeholder="Дата прилета" name="scheduledArrival"></p>
        </p>

    <p>
        Аэропорт прилета
        <select name="arrivalAirport" id="4">
            <option disabled>Выберите аэропорт прилета</option>
            <option value=""></option>
            <c:forEach var="arrivalAirport" items="${arrivalAirportList}">
                <option value="${arrivalAirport}">${arrivalAirport}</option>
            </c:forEach>
        </select>
    </p>


    <p><input type="submit" value="Поиск"></p>
</form>
<table border="4" bordercolor="#000000" cellspacing="1" cellpadding="10">
  <tbody>
    <tr>
      <th>ID</th>
      <th>Номер Аэропорта</th>
      <th>Дата вылета</th>
      <th>Дата прилета</th>
      <th>Аэропорт вылета</th>
      <th>Аэропорт прилета</th>

      <th>Статус</th>
      <th>aircraftCode</th>
      <th>actualDeparture</th>
      <th>actualArrival</th>
      м
    </tr>

<c:forEach var="flight" items="${flights}">
    <tr>
          <td>"${flight.flightId}"</td>
          <td>"${flight.flightNo}"</td>
          <td>"${flight.scheduledDeparture}"</td>
          <td>"${flight.scheduledArrival}"</td>

          <td>"${flight.departureAirport}"</td>
          <td>"${flight.arrivalAirport}"</td>
          <td>"${flight.status}"</td>

          <td>"${flight.aircraftCode}"</td>
          <td>"${flight.actualDeparture}"</td>
          <td>"${flight.actualArrival}"</td>
        </tr>
    </c:forEach>
</tbody>
</table>
</body>
</html>