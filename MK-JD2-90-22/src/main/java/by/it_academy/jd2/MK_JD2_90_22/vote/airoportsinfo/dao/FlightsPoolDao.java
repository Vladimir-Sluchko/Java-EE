package by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao;

import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.api.IFlights;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto.Flights;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto.FlightsFilter;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto.Page;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.utils.DateZonedUtils;

import java.sql.*;
import java.time.OffsetDateTime;
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
            "    bookings.flights_v" +
            "\n";


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
    public List<Flights> get(FlightsFilter filter, Page page) {
        List<Flights> airports = new ArrayList<>();
        if (filter == null){
            filter = FlightsFilter.Builder.creat().build();
        }

        if(page == null){
            page = Page.of(25, 1);
        }
        List<Object> param = new ArrayList<>();


        String where = "";

        if (filter.getArrivalAirport() != null && !filter.getArrivalAirport().isEmpty()) {
            where += "arrival_airport = ?";
            param.add(filter.getArrivalAirport());
        }
        if (filter.getDepartureAirport() != null && !filter.getDepartureAirport().isEmpty()) {
            if (!where.isEmpty()) {
                where += " AND ";
            }
            where += "departure_airport = ?";
            param.add(filter.getDepartureAirport());
        }
        if (filter.getScheduledDeparture() != null) {
            if (!where.isEmpty()) {
                where += " AND ";
            }
            where += "scheduled_departure = ?";
            param.add(filter.getScheduledDeparture());
        }
        if (filter.getScheduledArrival() != null) {
            if (!where.isEmpty()) {
                where += " AND ";
            }
            where += "scheduled_arrival = ?";
            param.add(filter.getScheduledArrival());
        }

        if (!where.isEmpty()) {
            where = "\n WHERE " + where;
        }

        String pageSize = "";

        if(page.getSize() > 0){
            pageSize += " LIMIT " + page.getSize();
        }
        if (page.getPage() > 0){
            int offset = page.getSize() * (page.getPage() - 1);

            pageSize += " OFFSET " + offset;
        }

        try (Connection connection = ConnectionBase.getConnection();
             PreparedStatement statement = connection.prepareStatement(QUERY + where + pageSize);
             ) {
            int index = 0;
            for (Object par : param) {
                statement.setObject(++index, par);
            }
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

    private Flights map(ResultSet rs) throws SQLException {
        return Flights.Builder.create()
                .setFlightId(rs.getLong("flight_id"))
                .setFlightNo(rs.getString("flight_no"))
                .setScheduledDeparture(rs.getObject("scheduled_departure", OffsetDateTime.class))
                .setScheduledDepartureLocal(dateZonedUtils.getLocalDateTime(rs,"scheduled_departure_local"))
                .setScheduledArrival(rs.getObject("scheduled_arrival",OffsetDateTime.class))
                .setScheduledArrivalLocal(dateZonedUtils.getLocalDateTime(rs,"scheduled_arrival_local"))
                .setScheduledDuration(dateZonedUtils.getDurationTime(rs,"scheduled_duration"))
                .setDepartureAirport(rs.getString("departure_airport"))
                .setDepartureAirportName(rs.getString("departure_airport_name"))
                .setDepartureCity(rs.getString("departure_city"))
                .setArrivalAirport(rs.getString("arrival_airport"))
                .setArrivalAirportName(rs.getString("arrival_airport_name"))
                .setArrivalCity(rs.getString("arrival_city"))
                .setStatus(rs.getString("status"))
                .setAircraftCode(rs.getString("aircraft_code"))
                .setActualDeparture(rs.getObject("actual_departure",OffsetDateTime.class))
                .setActualDepartureLocal(dateZonedUtils.getLocalDateTime(rs,"actual_departure_local"))
                .setActualArrival(rs.getObject("actual_arrival",OffsetDateTime.class))
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
