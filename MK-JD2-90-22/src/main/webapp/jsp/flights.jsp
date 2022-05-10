<%@ page contentType="text/html;charset=UTF-8"
         language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<html>
<head>
    <h3>Поиск полета</h3>
</head>
<body>
    <div>
        <form action="${pageContext.request.contextPath}/flights" method="get">
            <p>Аэропорт вылета
                <select name="departureAirport">
                    <option value="">Выберите аэропорт вылета</option>
                        <c:forEach var="filter" items="${requestScope.filtersList}">
                            <option
                                <c:if test="${filter.arrivalAirport eq requestScope.departureAirport}">
                                    selected
                                </c:if>
                            value="${filter.arrivalAirport}">${filter.arrivalAirport}</option>
                        </c:forEach>
                </select>
            <p>
            <p>Аэропорт прибытия
                <select name="arrivalAirport" id="4">
                    <option value="">Выберите аэропорт прибытия</option>
                        <c:forEach var="filter" items="${requestScope.filtersList}">
                            <option
                                <c:if test="${filter.arrivalAirport eq requestScope.arrivalAirport}">
                                    selected
                                </c:if>
                            value="${filter.arrivalAirport}">${filter.arrivalAirport}</option>
                        </c:forEach>
                </select>
            </p>
            <p>Дата вылета
                <select name="scheduledDeparture">
                    <option value="">Выберите дату вылета</option>
                        <c:forEach var="data" items="${requestScope.filtersAll}">
                            <option
                                <c:if test="${data.scheduledArrival eq requestScope.scheduledArrival}">
                                    selected
                                </c:if>
                            value="${data.scheduledDeparture}">${data.scheduledDeparture}</option>
                        </c:forEach>
                </select>
            </p>
            <p>Дата прибытия
                <select name="scheduledArrival" id="4">
                    <option value="">Выберите дату прибытия</option>
                        <c:forEach var="data" items="${requestScope.filtersAll}">
                            <option
                                <c:if test="${data.scheduledArrival eq requestScope.scheduledArrival}">
                                    selected
                                </c:if>
                            value="${data.scheduledArrival}">${data.scheduledArrival}</option>
                        </c:forEach>
                </select>
            </p>
            <p><input type="submit" value="Поиск"></p>
        </form>
    </div>
    <div>
        <form action="flights" method="get">
            <button name="page" value="-1" type="submit">Back </button>
            <button name="page" value="1" type="submit">Next </button>
        </form>
    </div>
    <div>
        <table class="table table-dark table-hover">
            <tr>
                <th> Flight Id </th>
                <th> Flight No </th>
                <th> Scheduled Departure </th>
                <th> Scheduled Departure Local </th>
                <th> Scheduled Arrival </th>
                <th> Scheduled Arrival Local </th>
                <th> Scheduled Duration </th>
                <th> Departure Airport </th>
                <th> Departure AirportName </th>
                <th> Departure City </th>
                <th> Arrival Airport </th>
                <th> Arrival Airport Name </th>
                <th> Arrival City </th>
                <th> Status </th>
                <th> Aircraft Code </th>
                <th> Actual Departure </th>
                <th> Actual Departure Local </th>
                <th> Actual Arrival </th>
                <th> Actual Arrival Local </th>
                <th> Actual Duration </th>
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
        </table>
    </div>
    <div>
        <form action="flights" method="get">
            <button name="page" value="-1" type="submit">Back </button>
            <button name="page" value="1" type="submit">Next </button>
        </form>
    </div>
</body>
</html>