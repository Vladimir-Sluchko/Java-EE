package airoportsinfo.dao.api;



import airoportsinfo.dao.dto.Flights;
import airoportsinfo.dao.dto.FlightsFilter;
import airoportsinfo.dao.dto.Page;

import java.util.List;

public interface IFlights extends AutoCloseable{
     List<Flights> getAll();
     List<Flights> get(FlightsFilter filter, Page page);
}
