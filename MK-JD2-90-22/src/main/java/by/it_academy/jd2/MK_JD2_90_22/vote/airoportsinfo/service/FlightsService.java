package by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.service;

import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.FlightsPoolDao;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.api.IFlights;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto.Flights;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto.FlightsFilter;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.service.api.IFlightsFilterService;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.service.api.IFlightsService;

import java.util.List;

public class FlightsService implements IFlightsService {
    public List<Flights> get(FlightsFilter filter) {
        List<Flights> flightsFilterList;
        try (IFlights flights = new FlightsPoolDao();) {
            flightsFilterList = flights.get(filter);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return flightsFilterList;
    }
}
