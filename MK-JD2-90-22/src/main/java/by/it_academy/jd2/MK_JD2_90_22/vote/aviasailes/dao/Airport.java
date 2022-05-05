package by.it_academy.jd2.MK_JD2_90_22.vote.aviasailes.dao;

public class Airport {
    private String code;
    private String name;
    private String city;
    private String coordinate;
    private String timezone;


    public Airport(String code, String name, String city, String coordinate, String timezone) {
        this.code = code;
        this.name = name;
        this.city = city;
        this.coordinate = coordinate;
        this.timezone = timezone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Airport{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", coordinate='" + coordinate + '\'' +
                ", timezone='" + timezone + '\'' +
                '}';
    }
}
