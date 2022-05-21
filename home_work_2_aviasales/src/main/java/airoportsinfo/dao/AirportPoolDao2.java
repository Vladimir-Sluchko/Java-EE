package airoportsinfo.dao;



import airoportsinfo.dao.api.IAirport;
import airoportsinfo.dao.dto.AirportInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirportPoolDao2 implements IAirport {
    private static final AirportPoolDao2 instance = new AirportPoolDao2();
    private static final String QUERY = "SELECT\n" +
            "    airport_code,\n" +
            "    airport_name,\n" +
            "    city,\n" +
            "    coordinates,\n" +
            "    timezone\n" +
            "FROM\n" +
            "    bookings.airports\n";

    private AirportPoolDao2(){

    }

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
