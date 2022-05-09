package by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao;

import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.api.IFlights;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto.Flights;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto.FlightsFilter;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.utils.DateZonedUtils;

import java.sql.*;
import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightsPoolDao implements IFlights {
    private final static FlightsPoolDao instance = new FlightsPoolDao();
    DateZonedUtils dateZonedUtils = DateZonedUtils.getInstance();

    private final static String QUERY = "SELECT\n" +
            "    flight_id,\n" +
            "    flight_no,\n" +
            "    scheduled_departure,\n" +
            "    scheduled_departure_local,\n" +
            "    scheduled_arrival,\n" +
            "    scheduled_arrival_local,\n" +
            "    scheduled_duration,\n" +
            "    departure_airport,\n" +
            "    departure_airport_name,\n" +
            "    departure_city,\n" +
            "    arrival_airport,\n" +
            "    arrival_airport_name,\n" +
            "    arrival_city,\n" +
            "    status,\n" +
            "    aircraft_code,\n" +
            "    actual_departure,\n" +
            "    actual_departure_local,\n" +
            "    actual_arrival,\n" +
            "    actual_arrival_local,\n" +
            "    actual_duration\n" +
            "FROM\n" +
            "    bookings.flights_v\n" +
            "LIMIT 50 \n";


    public List<Flights> getAll(){
        List<Flights> airports = new ArrayList<>();

        try (Connection connection = ConnectionBase.getConnection();
             PreparedStatement statement = connection.prepareStatement(QUERY);
        ) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    airports.add(map(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return airports;
    }

    @Override
    public List<Flights> get(FlightsFilter filter) {
        return null;
    }

    /*@Override
    public List<Flights> get(FlightsFilter filter) {
        List<Flights> airports = new ArrayList<>();
        filter.getDepartureAirport();
        filter.getScheduledDeparture();
        filter.getArrivalAirport();
        filter.getScheduledArrival();
        if (filter != null) {
            String where = "";
            if (filter.getArrivalAirport() != null && !filter.getArrivalAirport().isEmpty()) {
                where += "arrival_airport = " + "'" + filter.getArrivalAirport() + "'" + " ";
            }
            if (filter.getDepartureAirport() != null && !filter.getDepartureAirport().isEmpty()) {
                if (!where.isEmpty()) {
                    where += " AND ";
                }
                where += "departure_airport = "+"'" + filter.getDepartureAirport() +"'"+ " ";
            }
            if (filter.getScheduledDeparture() != null) {
                if (!where.isEmpty()) {
                    where += " AND ";
                }
                where += "scheduled_departure = " +"'" + filter.getScheduledDeparture() + "'" +" ";
            }
            if (filter.getScheduledArrival() != null) {
                if (!where.isEmpty()) {
                    where += " AND ";
                }
                where += "departure_airport = "+ "'"+ filter.getScheduledArrival() +"'"+ " ";
            }
            if (!where.isEmpty()) {
                sqlScript += "\n WHERE " + where;
            }else {

            }
        }

        try (Connection connection = ConnectionBase.getConnection();
             PreparedStatement statement = connection.prepareStatement(QUERY);

             ) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    airports.add(map(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return airports;
    }*/

    private Flights map(ResultSet rs) throws SQLException {
        return Flights.Builder.create()
                .setFlightId(rs.getLong("flight_id"))
                .setFlightNo(rs.getString("flight_no"))
                .setScheduledDeparture(dateZonedUtils.getZonedDateTime(rs,"scheduled_departure"))
                .setScheduledDepartureLocal(rs.getTimestamp("scheduled_departure_local").toLocalDateTime())
                .setScheduledArrival(dateZonedUtils.getZonedDateTime(rs,"scheduled_arrival"))
                .setScheduledArrivalLocal(rs.getTimestamp("scheduled_arrival_local").toLocalDateTime())
                .setScheduledDuration(dateZonedUtils.getDurationTime(rs,"scheduled_duration"))
                .setDepartureAirport(rs.getString("departure_airport"))
                .setDepartureAirportName(rs.getString("departure_airport_name"))
                .setDepartureCity(rs.getString("departure_city"))
                .setArrivalAirport(rs.getString("arrival_airport"))
                .setArrivalAirportName(rs.getString("arrival_airport_name"))
                .setArrivalCity(rs.getString("arrival_city"))
                .setStatus(rs.getString("status"))
                .setAircraftCode(rs.getString("aircraft_code"))
                .setActualDeparture(dateZonedUtils.getZonedDateTime(rs,"actual_departure"))
                .setActualDepartureLocal(dateZonedUtils.getLocalDateTime(rs,"actual_departure_local"))
                .setActualArrival(dateZonedUtils.getZonedDateTime(rs,"actual_arrival"))
                .setActualArrivalLocal(dateZonedUtils.getLocalDateTime(rs,"actual_arrival_local"))
                .setActualDuration(dateZonedUtils.getDurationTime(rs,"actual_duration"))
                .build();
    }

    @Override
    public void close() throws Exception {
        ConnectionBase.close();
    }

    public static FlightsPoolDao getInstance(){
        return instance;
    }
}
