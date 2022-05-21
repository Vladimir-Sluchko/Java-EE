package airoportsinfo.service.api;



import airoportsinfo.dao.dto.Flights;
import airoportsinfo.dao.dto.FlightsFilter;
import airoportsinfo.dao.dto.Page;

import java.util.List;

public interface IFlightsService {
    List<Flights> get(FlightsFilter filter, Page page);

    List<Flights> getAll(FlightsFilter filter);
}
