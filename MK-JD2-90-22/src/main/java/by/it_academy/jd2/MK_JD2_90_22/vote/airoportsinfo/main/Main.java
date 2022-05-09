package by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.main;

import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.FlightsPoolDao;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.api.IFlights;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto.Flights;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto.FlightsFilter;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.service.FlightsFilterService;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.service.api.IFlightsFilterService;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.DuplicateFormatFlagsException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ///Airport work
        /*IAirportService service = AirportService.getInstance();
        service.setSort("ASC");
        List<AirportInfo> all = service.getAll();

        for (AirportInfo airportInfo : all) {
            System.out.println(airportInfo);
        }*/

        IFlightsFilterService service = FlightsFilterService.getInstance();
        //FlightsFilter work aiport code

        /*List<FlightsFilter> arrivalAirport = service.getDistinctAirport("arrival_airport");
        for (FlightsFilter flightsFilter : arrivalAirport) {
            System.out.println(flightsFilter.getArrivalAirport());
        }*/
        //FlightsFilter work aiport code

        /*List<FlightsFilter> arrivalData = service.getDistinctData("scheduled_arrival");
        for (FlightsFilter arrivalDatum : arrivalData) {

            System.out.println(arrivalDatum.);
        }*/

        IFlights flights = FlightsPoolDao.getInstance();
        List<Flights> all = flights.getAll();
        for (Flights flights1 : all) {
            System.out.println(flights1.getScheduledDuration());
        }




    }
}
