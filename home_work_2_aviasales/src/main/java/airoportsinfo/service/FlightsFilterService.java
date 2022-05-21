package airoportsinfo.service;



import airoportsinfo.dao.FlightsFilterPoolDao;
import airoportsinfo.dao.api.IFlightsFilter;
import airoportsinfo.dao.dto.FlightsFilter;
import airoportsinfo.service.api.IFlightsFilterService;

import java.time.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FlightsFilterService  implements IFlightsFilterService {

    private final IFlightsFilter dao;
    private static final FlightsFilterService instance = new FlightsFilterService();

    public FlightsFilterService() {
        this.dao = FlightsFilterPoolDao.getInstance();
    }

    public List<FlightsFilter> getAll() {
        return dao.getAll();
    }

    @Override
    public List<FlightsFilter> getDistinctAirport(String columnName) {
        List<FlightsFilter> list = dao.getDistinctAirport(columnName);
        if (columnName != null && !columnName.isEmpty()){
            Collections.sort(list, new Comparator<FlightsFilter>() {
                public int compare(FlightsFilter o1, FlightsFilter o2) {
                    return o1.getArrivalAirport().toString().compareTo(o2.getArrivalAirport().toString());
                }
            });
        }

        return list;
    }
    public FlightsFilter filterSaveToPage(String departureAirport, String arrivalAirport,
                                             String scheduledDeparture,String scheduledArrival){
        FlightsFilter.Builder builder = FlightsFilter.Builder.creat();
        if(departureAirport != null && !departureAirport.isEmpty()){
            builder.setDepartureAirport(departureAirport);
        }
        if(arrivalAirport != null && !arrivalAirport.isEmpty()){
            builder.setArrivalAirport(arrivalAirport);
        }
        if(scheduledDeparture != null && !scheduledDeparture.isEmpty()){
            LocalDate date = LocalDate.parse(scheduledDeparture);
            ZoneOffset offset = ZoneOffset.UTC;
            builder.setScheduledDeparture(date.atTime(OffsetTime.of(LocalTime.MIDNIGHT, offset).withSecond(0)));
        }
        if(scheduledArrival != null && !scheduledArrival.isEmpty()){
            LocalDate date = LocalDate.parse(scheduledArrival);
            ZoneOffset offset = ZoneOffset.UTC;
            builder.setScheduledArrival(date.atTime(OffsetTime.of(LocalTime.MIDNIGHT, offset)));
        }

        FlightsFilter filterSaveToPage = builder.build();
        return filterSaveToPage;
    }

    @Override
    public List<FlightsFilter> getDistinctData(String columnName) {
        return dao.getDistinctData(columnName);
    }

    public static  FlightsFilterService getInstance(){
        return instance;
    }


}
