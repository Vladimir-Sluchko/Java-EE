package airoportsinfo.controllers.json.dto;



import airoportsinfo.dao.dto.Flights;
import airoportsinfo.dao.dto.FlightsFilter;

import java.util.List;

public class PageParam {
    public List<Flights> flights;
    public List<FlightsFilter> filtersList;
    public List<FlightsFilter> filtersAll;

    public PageParam(List<Flights> flights, List<FlightsFilter> filtersList, List<FlightsFilter> filtersAll) {
        this.flights = flights;
        this.filtersList = filtersList;
        this.filtersAll = filtersAll;
    }

    public List<Flights> getFlights() {
        return flights;
    }

    public void setFlights(List<Flights> flights) {
        this.flights = flights;
    }

    public List<FlightsFilter> getFiltersList() {
        return filtersList;
    }

    public void setFiltersList(List<FlightsFilter> filtersList) {
        this.filtersList = filtersList;
    }

    public List<FlightsFilter> getFiltersAll() {
        return filtersAll;
    }

    public void setFiltersAll(List<FlightsFilter> filtersAll) {
        this.filtersAll = filtersAll;
    }
}
