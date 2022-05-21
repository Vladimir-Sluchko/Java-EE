package airoportsinfo.web.servlets;



import airoportsinfo.dao.dto.Flights;
import airoportsinfo.dao.dto.FlightsFilter;
import airoportsinfo.dao.dto.Page;
import airoportsinfo.service.FlightsFilterService;
import airoportsinfo.service.FlightsService;
import airoportsinfo.service.PageService;
import airoportsinfo.service.api.IFlightsFilterService;
import airoportsinfo.service.api.IFlightsService;
import airoportsinfo.service.api.IPageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;

@WebServlet(name = "FlightsServlet", urlPatterns = "/flights")
public class FlightsServlet extends HttpServlet {
    IFlightsFilterService flightsFilterService;
    Page pageOf;
    IFlightsService flightsService;
    IPageService pageService;
    public FlightsServlet() {
        this.flightsFilterService = FlightsFilterService.getInstance();
        this.flightsService = FlightsService.getInstance();
        this.pageService = PageService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        List<FlightsFilter> filtersList = flightsFilterService.getDistinctAirport("arrival_airport");
        List<FlightsFilter> filtersAll = flightsFilterService.getAll();

        String departureAirport = req.getParameter("departureAirport");
        String arrivalAirport = req.getParameter("arrivalAirport");
        //получили дату
        String scheduledDeparture = req.getParameter("scheduledDeparture");
        String scheduledArrival = req.getParameter("scheduledArrival");
        //String scheduledArrival2 = req.getParameter("scheduledArrival2");

        FlightsFilter filterSaveToPage = flightsFilterService
                .filterSaveToPage(departureAirport, arrivalAirport, scheduledDeparture, scheduledArrival);

        String reqPage = req.getParameter("page");
        String reqSize = req.getParameter("size");
        pageOf = pageService.countPage(reqPage,pageOf);

        List<Flights> flights = flightsService.get(filterSaveToPage,pageOf);
        req.setAttribute("flights",flights);
        req.setAttribute("filtersList",filtersList);
        //req.setAttribute("filtersAll",filtersAll);
        req.setAttribute("departureAirport",filterSaveToPage.getDepartureAirport());
        req.setAttribute("arrivalAirport",filterSaveToPage.getArrivalAirport());
        req.setAttribute("scheduledDeparture2",scheduledDeparture);
        req.setAttribute("scheduledArrival2",scheduledArrival);
        req.setAttribute("page",pageOf.getPage());
        req.getRequestDispatcher("/jsp/flights.jsp").forward(req,resp);
    }

}
