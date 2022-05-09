<%@ page contentType="text/html;charset=UTF-8"
         language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h3>Поиск полета</h3>

<form action="flights" method="get">

    <p>
        Дата вылета
            <input type="date", placeholder="Дата вылета" name="scheduledDeparture"></p>
    </p>
    <p>
        Аэропорт вылета
        <select name="departureAirport" id="2">
            <option disabled>Выберите аэропорт вылета</option>
            <option value=""></option>
            <c:forEach var="filter" items="${filtersList}">
                <option value="${filter.arrivalAirport}">${filter.arrivalAirport}</option>
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
            <c:forEach var="filter" items="${filtersList}">
                <option value="${filter.arrivalAirport}">${filter.arrivalAirport}</option>
            </c:forEach>
        </select>
    </p>


    <p><input type="submit" value="Поиск"></p>
</form>


<table border="4" bordercolor="#000000" cellspacing="1" cellpadding="10">
  <tbody>
    <tr>
      <th> flightId </th>
      <th> flightNo </th>
      <th> scheduledDeparture </th>
      <th> scheduledDepartureLocal </th>
      <th> scheduledArrival </th>
      <th> scheduledArrivalLocal </th>
      <th> scheduledDuration </th>
      <th> departureAirport </th>
      <th> departureAirportName </th>
      <th> departureCity </th>
      <th> arrivalAirport </th>
      <th> arrivalAirportName </th>
      <th> arrivalCity </th>
      <th> status </th>
      <th> aircraftCode </th>
      <th> actualDeparture </th>
      <th> actualDepartureLocal </th>
      <th> actualArrival </th>
      <th> actualArrivalLocal </th>
      <th> actualDuration </th>
    </tr>

<c:forEach var="flight" items="${flights}">
    <tr>
          <td> "${flight.flightId }"</td>
          <td> "${flight.flightNo }"</td>
          <td> "${flight.scheduledDeparture }"</td>
          <td> "${flight.scheduledDepartureLocal }"</td>
          <td> "${flight.scheduledArrival }"</td>
          <td> "${flight.scheduledArrivalLocal }"</td>
          <td> "${flight.scheduledDuration }"</td>
          <td> "${flight.departureAirport }"</td>
          <td> "${flight.departureAirportName }"</td>
          <td> "${flight.departureCity }"</td>
          <td> "${flight.arrivalAirport }"</td>
          <td> "${flight.arrivalAirportName }"</td>
          <td> "${flight.arrivalCity }"</td>
          <td> "${flight.status }"</td>
          <td> "${flight.aircraftCode }"</td>
          <td> "${flight.actualDeparture }"</td>
          <td> "${flight.actualDepartureLocal }"</td>
          <td> "${flight.actualArrival }"</td>
          <td> "${flight.actualArrivalLocal }"</td>
          <td> "${flight.actualDuration }"</td>
        </tr>
    </c:forEach>
</tbody>
</table>
</body>
</html>