package by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto;

import java.time.ZonedDateTime;

public class FlightsFilterZone {
    private final ZonedDateTime scheduledDeparture;
    private final String departureAirport;
    private final ZonedDateTime scheduledArrival;
    private final String arrivalAirport;

     private FlightsFilterZone(ZonedDateTime scheduledDeparture,
                               String departureAirport,
                               ZonedDateTime scheduledArrival,
                               String arrivalAirport) {
        this.scheduledDeparture = scheduledDeparture;
        this.departureAirport = departureAirport;
        this.scheduledArrival = scheduledArrival;
        this.arrivalAirport = arrivalAirport;
    }


    public ZonedDateTime getScheduledDeparture() {
        return scheduledDeparture;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public ZonedDateTime getScheduledArrival() {
        return scheduledArrival;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }


    /////


    public static class Builder {
        private String departureAirport;
        private String arrivalAirport;
        private ZonedDateTime scheduledDeparture;
        private ZonedDateTime scheduledArrival;

        private Builder() {
        }



        public Builder setScheduledDeparture(ZonedDateTime scheduledDeparture) {
            this.scheduledDeparture = scheduledDeparture;
            return this;
        }

        public Builder setDepartureAirport(String departureAirport) {
            this.departureAirport = departureAirport;
            return this;
        }

        public Builder setScheduledArrival(ZonedDateTime scheduledArrival) {
            this.scheduledArrival = scheduledArrival;
            return this;
        }

        public Builder setArrivalAirport(String arrivalAirport) {
            this.arrivalAirport = arrivalAirport;
            return this;
        }


        public static Builder creat(){
            return new Builder();
        }
        public FlightsFilterZone build() {
            return new FlightsFilterZone(scheduledDeparture,departureAirport,scheduledArrival,arrivalAirport);
        }
    }
}
