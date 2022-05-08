package by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao;

import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.api.IFlights;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto.AirportInfo;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto.Flights;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto.FlightsFilter;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FlightsPoolDao implements IFlights {
    //private static IFlights instance = new FlightsPoolDao();
    private final DataSource ds;

    public FlightsPoolDao() {
        ComboPooledDataSource pool = new ComboPooledDataSource();
        try {
            pool.setDriverClass("org.postgresql.Driver");
        } catch (PropertyVetoException e) {
            throw new RuntimeException("Проверь имя драйвера!!!!", e);
        }
        pool.setJdbcUrl("jdbc:postgresql://localhost:5432/demo");
        pool.setUser("postgres");
        pool.setPassword("postgres");

        this.ds = pool;
    }

    /*public List<Flights> getAll(){
        List<Flights> airports = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT\n" +
                             "    flight_id,\n" +
                             "    flight_no,\n" +
                             "    scheduled_departure,\n" +
                             "    scheduled_arrival,\n" +
                             "    departure_airport,\n" +
                             "    arrival_airport,\n" +
                             "    status,\n" +
                             "    aircraft_code,\n" +
                             "    actual_departure,\n" +
                             "    actual_arrival\n" +
                             "FROM\n" +
                             "    bookings.flights_v\n" +
                             "LIMIT 100;"
             );
        ) {
            while (resultSet.next()){
                airports.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return airports;
    }*/

    @Override
    public List<Flights> get(FlightsFilter filter) {
        List<Flights> airports = new ArrayList<>();
        String sqlScript = "SELECT\n" +
                "    flight_id,\n" +
                "    flight_no,\n" +
                "    scheduled_departure,\n" +
                "    scheduled_arrival,\n" +
                "    departure_airport,\n" +
                "    arrival_airport,\n" +
                "    status,\n" +
                "    aircraft_code,\n" +
                "    actual_departure,\n" +
                "    actual_arrival\n" +
                "FROM\n" +
                "    bookings.flights_v\n";
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

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlScript);) {
            while (resultSet.next()){
                airports.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return airports;
    }

    private Connection getConnection() throws SQLException {
        return this.ds.getConnection();
    }

    private Flights map(ResultSet rs) throws SQLException {

        return new Flights(
                rs.getInt("flight_id"),
                rs.getString("flight_no"),
                rs.getTimestamp("scheduled_departure").toLocalDateTime(),
                rs.getTimestamp("scheduled_arrival").toLocalDateTime(),
                rs.getString("departure_airport"),
                rs.getString("arrival_airport"),
                rs.getString("status"),
                rs.getString("aircraft_code"),
                rs.getString("actual_departure"),
                rs.getString("actual_arrival")

        );
    }

    @Override
    public void close() throws Exception {
        DataSources.destroy(this.ds);
    }
}
