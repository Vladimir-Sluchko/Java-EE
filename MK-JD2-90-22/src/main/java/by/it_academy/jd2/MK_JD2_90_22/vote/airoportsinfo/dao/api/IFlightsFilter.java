package by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.api;

import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto.FlightsFilter;

import java.util.List;

public interface IFlightsFilter extends AutoCloseable{

     List<FlightsFilter> getAll();

     /*List<String> getDistinct(String columnName);*/
     List<FlightsFilter> getDistinctAirport(String columnName);
     List<FlightsFilter> getDistinctData(String columnName);


}
