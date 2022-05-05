package by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto;

public class AirportInfo {
    private String airportCode;
    private String airportName;
    private String city;
    private String coordinate;
    private String timezone;

    public AirportInfo(String airportCode, String airportName, String city, String coordinate, String timezone) {
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.city = city;
        this.coordinate = coordinate;
        this.timezone = timezone;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @Override
    public String toString() {
        return "AirportInfo{" +
                "airportCode='" + airportCode + '\'' +
                ", airportName='" + airportName + '\'' +
                ", city='" + city + '\'' +
                ", coordinate='" + coordinate + '\'' +
                ", timezone='" + timezone + '\'' +
                '}';
    }

}
