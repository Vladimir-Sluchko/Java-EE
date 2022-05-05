package by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto;

import java.time.LocalDateTime;

public class FlightsFilter {
    private LocalDateTime scheduledDeparture;
    private String departureAirport;
    private LocalDateTime scheduledArrival;
    private String arrivalAirport;

    public FlightsFilter(LocalDateTime scheduledDeparture,
                         String departureAirport,
                         LocalDateTime scheduledArrival,
                         String arrivalAirport) {
        this.scheduledDeparture = scheduledDeparture;
        this.departureAirport = departureAirport;
        this.scheduledArrival = scheduledArrival;
        this.arrivalAirport = arrivalAirport;
    }

    public LocalDateTime getScheduledDeparture() {
        return scheduledDeparture;
    }

    public void setScheduledDeparture(LocalDateTime scheduledDeparture) {
        this.scheduledDeparture = scheduledDeparture;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public LocalDateTime getScheduledArrival() {
        return scheduledArrival;
    }

    public void setScheduledArrival(LocalDateTime scheduledArrival) {
        this.scheduledArrival = scheduledArrival;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public static class Builder {
        private String departureAirport;
        private String arrivalAirport;
        private LocalDateTime scheduledDeparture;
        private LocalDateTime scheduledArrival;

        private Builder() {
        }

        public static Builder builder(){
            return new Builder();
        }

        public Builder setScheduledDeparture(LocalDateTime scheduledDeparture) {
            this.scheduledDeparture = scheduledDeparture;
            return this;
        }

        public Builder setDepartureAirport(String departureAirport) {
            this.departureAirport = departureAirport;
            return this;
        }

        public Builder setScheduledArrival(LocalDateTime scheduledArrival) {
            this.scheduledArrival = scheduledArrival;
            return this;
        }

        public Builder setArrivalAirport(String arrivalAirport) {
            this.arrivalAirport = arrivalAirport;
            return this;
        }



        public FlightsFilter build() {
            return new FlightsFilter(scheduledDeparture,departureAirport,scheduledArrival,arrivalAirport);
        }
    }
}
