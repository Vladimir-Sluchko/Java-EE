package by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.*;
import java.util.Date;

public class DateZonedUtils {
    private static final DateZonedUtils instance = new DateZonedUtils();

    public ZonedDateTime getZonedDateTime(ResultSet rs, String param) throws SQLException {
        Timestamp ts = rs.getTimestamp(param);
        if(ts == null){
            return null;
        }else  return ZonedDateTime.ofInstant(ts.toInstant(), ZoneId.systemDefault());
    }

    public LocalDateTime getLocalDateTime(ResultSet rs, String param) throws SQLException {
        Timestamp ts = rs.getTimestamp(param);
        if(ts == null) {
            return null;
        } else return ts.toLocalDateTime();
    }

    public Duration getDurationTime(ResultSet rs,String param) throws SQLException{
        if(rs.getString(param) == null){
            return null;
        }else return Duration.between (
                LocalTime.MIN ,
                LocalTime.parse ( rs.getString(param) ));
    }



    public static DateZonedUtils getInstance(){
        return instance;
    }
}
