package airoportsinfo.main;



import airoportsinfo.dao.FlightsPoolDao;
import airoportsinfo.dao.api.IFlights;
import airoportsinfo.dao.dto.AirportInfo;
import airoportsinfo.dao.dto.Flights;
import airoportsinfo.dao.dto.FlightsFilter;
import airoportsinfo.dao.dto.Page;
import airoportsinfo.service.AirportService;
import airoportsinfo.service.FlightsFilterService;
import airoportsinfo.service.FlightsService;
import airoportsinfo.service.api.IAirportService;
import airoportsinfo.service.api.IFlightsFilterService;
import airoportsinfo.service.api.IFlightsService;

import java.time.*;
import java.time.format.DateTimeFormatter;
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
        String str = "2017-05-11";
        LocalDate date = LocalDate.parse(str);
        ZoneOffset offset = ZoneOffset.UTC;
        OffsetDateTime odt = date.atTime(OffsetTime.of(LocalTime.MIDNIGHT, offset));
        String offsetDateStr = odt.toString();
        System.out.println(odt);
        //OffsetDateTime parse = OffsetDateTime.parse(date);



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
        IFlightsFilterService iFlightsFilterService = FlightsFilterService.getInstance();
        FlightsFilter filterSaveToPage = iFlightsFilterService.filterSaveToPage("VOG", null, str, null);

        IFlightsService flightsService = FlightsService.getInstance();
        Page pageOf = new Page();
        List<Flights> flights = flightsService.get(filterSaveToPage,pageOf);
        for (Flights flight : flights) {
            System.out.println(flight);

        }


    }
}
