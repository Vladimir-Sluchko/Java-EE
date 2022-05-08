package by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao;

import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.api.IAirport;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto.AirportInfo;
import by.it_academy.jd2.MK_JD2_90_22.vote.aviasailes.dao.Airport;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirportPoolDao2 implements IAirport {
    private static final String QUERY = "SELECT\n" +
            "    airport_code,\n" +
            "    airport_name,\n" +
            "    city,\n" +
            "    coordinates,\n" +
            "    timezone\n" +
            "FROM\n" +
            "    bookings.airports\n";
    private static final AirportPoolDao2 instance = new AirportPoolDao2();
    private AirportPoolDao2(){

    }
    //private final DataSource ds;

    /*public AirportPoolDao2() {
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
    }*/

    public List<AirportInfo> getAll(String sort){
        List<AirportInfo> airports = new ArrayList<>();
        String orderBy = "";
        if (sort == null){
            sort = "";
        }
        if (sort.length() > 0){
            orderBy = "ORDER BY city " + sort + ";";
        }

        try (Connection connection = ConnectionBase.getConnection();
             PreparedStatement statement = connection.prepareStatement(QUERY + orderBy);
             ) {
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    airports.add(map(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return airports;
    }


    /*private Connection getConnection() throws SQLException {
        return this.ds.getConnection();
    }*/

    private AirportInfo map(ResultSet rs) throws SQLException {
        return new AirportInfo(
                rs.getString("airport_code"),
                rs.getString("airport_name"),
                rs.getString("city"),
                rs.getString("coordinates"),
                rs.getString("timezone")
        );
    }

    @Override
    public void close() throws Exception {
        ConnectionBase.close();
    }
    public static AirportPoolDao2 getInstance(){
        return instance;
    }
}
