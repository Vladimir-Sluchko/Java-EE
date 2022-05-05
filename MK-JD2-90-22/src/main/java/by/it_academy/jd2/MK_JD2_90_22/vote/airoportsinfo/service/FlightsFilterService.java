package by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.service;

import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.AirportPoolDao2;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.FlightsFilterPoolDao;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.api.IAirport;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.api.IFlights;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.api.IFlightsFilter;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto.AirportInfo;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto.Flights;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto.FlightsFilter;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.service.api.IFlightsFilterService;

import java.util.List;

public class FlightsFilterService implements IFlightsFilterService {

    public List<FlightsFilter> getAll() {
        List<FlightsFilter> flightsFilterList;
        try (IFlightsFilter flightsFilter = new FlightsFilterPoolDao();) {
            flightsFilterList = flightsFilter.getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return flightsFilterList;
    }

    public List<String> getDistinct(String columnName){
        List<String> list;
        try (IFlightsFilter flightsFilter = new FlightsFilterPoolDao();) {
            list = flightsFilter.getDistinct(columnName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }



}
