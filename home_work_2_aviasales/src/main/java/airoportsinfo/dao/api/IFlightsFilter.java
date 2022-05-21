package airoportsinfo.dao.api;



import airoportsinfo.dao.dto.FlightsFilter;

import java.util.List;

public interface IFlightsFilter extends AutoCloseable{

     List<FlightsFilter> getAll();

     /*List<String> getDistinct(String columnName);*/
     List<FlightsFilter> getDistinctAirport(String columnName);
     List<FlightsFilter> getDistinctData(String columnName);


}
