package airoportsinfo.service.api;



import airoportsinfo.dao.dto.FlightsFilter;

import java.util.List;

public interface IFlightsFilterService {

    List<FlightsFilter> getAll();

    List<FlightsFilter> getDistinctAirport(String columnName);
    List<FlightsFilter> getDistinctData(String columnName);
    FlightsFilter filterSaveToPage(String departureAirport, String arrivalAirport,
                                   String scheduledDeparture,String scheduledArrival);
}
