package by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao;

import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.api.IFlightsFilter;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto.FlightsFilter;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.utils.DateZonedUtils;

import java.sql.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightsFilterPoolDao implements IFlightsFilter {
    private final static FlightsFilterPoolDao instance = new FlightsFilterPoolDao();
    private static final String QUERY = "SELECT\n" +
            "    scheduled_departure,\n" +
            "    departure_airport,\n" +
            "    scheduled_arrival,\n" +
            "    arrival_airport\n" +
            "FROM\n" +
            "    bookings.flights_v\n" +
            "LIMIT 100;";
    private static final String QUERY_DISTINCT = "SELECT ";
    private FlightsFilterPoolDao(){

    }

    public List<FlightsFilter> getAll(){
        List<FlightsFilter> airports = new ArrayList<>();

        try (Connection connection = ConnectionBase.getConnection();
             PreparedStatement statement = connection.prepareStatement(QUERY);
        ) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    airports.add(mapAll(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return airports;
    }

    ///пробный
    public List<FlightsFilter> getDistinctAirport(String columnName){
        List<FlightsFilter> coluNameDist = new ArrayList<>();
        String str = "";
        if (columnName == null){
            columnName = "";
        }
        if(columnName.length() > 0){
            str = "DISTINCT " + columnName + " FROM bookings.flights_v;";
        }

        try (Connection connection = ConnectionBase.getConnection();
             PreparedStatement statement = connection.prepareStatement(QUERY_DISTINCT + str);
        ) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    coluNameDist.add(mapDistinctAirport(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return coluNameDist;
    }
    public List<FlightsFilter> getDistinctData(String columnName){
        List<FlightsFilter> coluNameDist = new ArrayList<>();
        String str = "";
        if (columnName == null){
            columnName = "";
        }
        if(columnName.length() > 0){
            str = "DISTINCT " + columnName + " FROM bookings.flights_v;";
        }

        try (Connection connection = ConnectionBase.getConnection();
             PreparedStatement statement = connection.prepareStatement(QUERY_DISTINCT + str);
        ) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    coluNameDist.add(mapDistinctData(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return coluNameDist;
    }

    private FlightsFilter mapDistinctAirport(ResultSet rs) throws SQLException {
        return FlightsFilter.Builder.creat()
                .setArrivalAirport(rs.getString("arrival_airport")).build();
    }
    private FlightsFilter mapDistinctData(ResultSet rs) throws SQLException {
        return FlightsFilter.Builder.creat()
                .setScheduledArrival(rs.getObject("scheduled_arrival",OffsetDateTime.class))
                .build();
    }

    private FlightsFilter mapAll(ResultSet rs) throws SQLException {
        return FlightsFilter.Builder.creat()
                .setScheduledArrival(rs.getObject("scheduled_arrival",OffsetDateTime.class))
                .setScheduledDeparture(rs.getObject("scheduled_departure", OffsetDateTime.class))
                .setArrivalAirport(rs.getString("arrival_airport"))
                .setDepartureAirport(rs.getString("departure_airport")).build();
    }



    @Override
    public void close() throws Exception {
        ConnectionBase.close();
    }
    public static FlightsFilterPoolDao getInstance(){
        return instance;
    }
}
