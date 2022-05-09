package by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.service.api;

import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto.Flights;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto.FlightsFilter;

import java.util.List;

public interface IFlightsService {
    List<Flights> get(FlightsFilter filter);
    List<Flights> getAll(FlightsFilter filter);
}
