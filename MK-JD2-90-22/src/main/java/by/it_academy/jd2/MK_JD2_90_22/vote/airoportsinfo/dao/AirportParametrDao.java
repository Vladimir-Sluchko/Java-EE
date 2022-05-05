package by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao;

import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.api.IParametr;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto.AirportInfo;
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

public class AirportParametrDao  {

   /* private DataSource ds;

    public AirportPoolDao2() {
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
    @Override
    public List<AirportInfo> getByColumnName(String columnName, String tableName) {
        List<String> airports = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT\n" +
                             "    ml.airport_code,\n" +
                             "    ml.airport_name ->> lang () AS airport_name,\n" +
                             "    ml.city ->> lang () AS city,\n" +
                             "    ml.coordinates,\n" +
                             "    ml.timezone\n" +
                             "FROM\n" +
                             "    airports_data ml\n" +
                             "ORDER BY\n" +
                             "    city " + sort + ";"
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

        return null;
    }

    public List<AirportInfo> getAll(String sort){
        List<AirportInfo> airports = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT\n" +
                             "    ml.airport_code,\n" +
                             "    ml.airport_name ->> lang () AS airport_name,\n" +
                             "    ml.city ->> lang () AS city,\n" +
                             "    ml.coordinates,\n" +
                             "    ml.timezone\n" +
                             "FROM\n" +
                             "    airports_data ml\n" +
                             "ORDER BY\n" +
                             "    city " + sort + ";"
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

    private Connection getConnection() throws SQLException {
        return this.ds.getConnection();
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
        DataSources.destroy(this.ds);
    }*/
}
