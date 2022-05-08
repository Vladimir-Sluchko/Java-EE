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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FlightsFilterService  implements IFlightsFilterService{

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
        Collections.sort(list, new Comparator<FlightsFilter>() {
            public int compare(FlightsFilter o1, FlightsFilter o2) {
                return o1.getArrivalAirport().toString().compareTo(o2.getArrivalAirport().toString());
            }
        });
        return list;
    }

    @Override
    public List<FlightsFilter> getDistinctData(String columnName) {
        return dao.getDistinctData(columnName);
    }

    public static  FlightsFilterService getInstance(){
        return instance;
    }


}
