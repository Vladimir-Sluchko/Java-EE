package by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao;

import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.api.IFlightsFilter;
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

public class FlightsFilterPoolDao implements IFlightsFilter {
    private DataSource ds;

    public FlightsFilterPoolDao() {
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

    public List<FlightsFilter> getAll(){
        List<FlightsFilter> airports = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT\n" +
                             "    scheduled_departure,\n" +
                             "    departure_airport,\n" +
                             "    scheduled_arrival,\n" +
                             "    arrival_airport\n" +
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
    }

    public List<String> getDistinct(String columnName){
        List<String> coluNameDist = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT DISTINCT\n" +
                             columnName +
                             " FROM\n" +
                             "    bookings.flights_v;"
             );
        ) {
            while (resultSet.next()){
                String colum = resultSet.getString(columnName);
                coluNameDist.add(colum);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return coluNameDist;
    }

    private String map2(ResultSet rs) throws SQLException {

        return new String(
                rs.getString("uncName")
        );
    }



    private Connection getConnection() throws SQLException {
        return this.ds.getConnection();
    }

    private FlightsFilter map(ResultSet rs) throws SQLException {

        return new FlightsFilter(
                null,
                rs.getString("departure_airport"),
                null,
                rs.getString("arrival_airport")
        );
    }

    @Override
    public void close() throws Exception {
        DataSources.destroy(this.ds);
    }
}
