package by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.api;

import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.Page;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto.Flights;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto.FlightsFilter;

import java.util.List;

public interface IFlights extends AutoCloseable{
     List<Flights> getAll();
     List<Flights> get(FlightsFilter filter, Page page);
}
