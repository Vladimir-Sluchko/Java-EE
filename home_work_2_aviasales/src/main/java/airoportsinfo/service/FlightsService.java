package airoportsinfo.service;



import airoportsinfo.dao.FlightsPoolDao;
import airoportsinfo.dao.api.IFlights;
import airoportsinfo.dao.dto.Flights;
import airoportsinfo.dao.dto.FlightsFilter;
import airoportsinfo.dao.dto.Page;
import airoportsinfo.service.api.IFlightsService;

import java.util.List;

public class FlightsService implements IFlightsService {
    private static final FlightsService instance = new FlightsService();
    IFlights flights = FlightsPoolDao.getInstance();

    /*public List<Flights> get(FlightsFilter filter) {
        List<Flights> flightsFilterList;
        try (IFlights flights = new FlightsPoolDao();) {
            flightsFilterList = flights.get(filter);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return flightsFilterList;
    }*/

    @Override
    public List<Flights> get(FlightsFilter filter, Page page) {
        return flights.get(filter,page);
    }

    @Override
    public List<Flights> getAll(FlightsFilter filter) {
        return flights.getAll();
    }

    public static FlightsService getInstance(){
        return instance;
    }
}
