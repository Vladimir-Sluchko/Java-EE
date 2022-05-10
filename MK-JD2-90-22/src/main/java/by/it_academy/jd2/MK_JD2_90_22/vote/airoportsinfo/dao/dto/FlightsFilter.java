package by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class FlightsFilter {
    private final OffsetDateTime scheduledDeparture;
    private final String departureAirport;
    private final OffsetDateTime scheduledArrival;
    private final String arrivalAirport;

     private FlightsFilter(OffsetDateTime scheduledDeparture,
                           String departureAirport,
                           OffsetDateTime scheduledArrival,
                           String arrivalAirport) {
        this.scheduledDeparture = scheduledDeparture;
        this.departureAirport = departureAirport;
        this.scheduledArrival = scheduledArrival;
        this.arrivalAirport = arrivalAirport;
    }


    public OffsetDateTime getScheduledDeparture() {
        return scheduledDeparture;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public OffsetDateTime getScheduledArrival() {
        return scheduledArrival;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }


    /////


    public static class Builder {
        private String departureAirport;
        private String arrivalAirport;
        private OffsetDateTime scheduledDeparture;
        private OffsetDateTime scheduledArrival;

        private Builder() {
        }



        public Builder setScheduledDeparture(OffsetDateTime scheduledDeparture) {
            this.scheduledDeparture = scheduledDeparture;
            return this;
        }

        public Builder setDepartureAirport(String departureAirport) {
            this.departureAirport = departureAirport;
            return this;
        }

        public Builder setScheduledArrival(OffsetDateTime scheduledArrival) {
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
        public FlightsFilter build() {
            return new FlightsFilter(scheduledDeparture,departureAirport,scheduledArrival,arrivalAirport);
        }
    }
}
