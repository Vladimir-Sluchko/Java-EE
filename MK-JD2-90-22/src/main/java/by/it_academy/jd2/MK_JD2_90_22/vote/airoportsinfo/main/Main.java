package by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.main;

import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.AirportPoolDao2;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.FlightsFilterPoolDao;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.api.IFlights;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.api.IFlightsFilter;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto.AirportInfo;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto.FlightsFilter;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.service.AirportService;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.service.FlightsFilterService;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.service.api.IAirportService;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.service.api.IFlightsFilterService;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.service.api.IFlightsService;
import by.it_academy.jd2.MK_JD2_90_22.vote.aviasailes.dao.AirportPoolDao;

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
        //FlightsFilter work
        IFlightsFilterService service = FlightsFilterService.getInstance();
        //IFlightsFilter flightsDao = FlightsFilterPoolDao.getInstance();
        List<FlightsFilter> arrivalAirport = service.getDistinctAirport("arrival_airport");
        List<FlightsFilter> arrivalData = service.getDistinctData("scheduled_arrival");
        for (FlightsFilter flightsFilter : arrivalAirport) {
            System.out.println(flightsFilter.getArrivalAirport());
        }
        /*for (FlightsFilter arrivalDatum : arrivalData) {
            System.out.println(arrivalDatum.getScheduledArrival());

        }*/


    }
}
