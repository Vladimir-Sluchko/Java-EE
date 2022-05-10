package by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.web.servlets;

import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.Page;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto.Flights;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.dto.FlightsFilter;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.service.FlightsFilterService;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.service.FlightsService;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.service.api.IFlightsFilterService;
import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.service.api.IFlightsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.List;

import static java.time.format.DateTimeFormatter.ISO_ZONED_DATE_TIME;

@WebServlet(name = "FlightsServlet", urlPatterns = "/flights")
public class FlightsServlet extends HttpServlet {
    IFlightsFilterService flightsFilterService;
    IFlightsService flightsService;
    public FlightsServlet() {
        this.flightsFilterService = FlightsFilterService.getInstance();
        this.flightsService = FlightsService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        List<FlightsFilter> filtersList = flightsFilterService.getDistinctAirport("arrival_airport");
        List<FlightsFilter> filtersAll = flightsFilterService.getAll();

        String departureAirport = req.getParameter("departureAirport");
        String arrivalAirport = req.getParameter("arrivalAirport");

        FlightsFilter.Builder builder = FlightsFilter.Builder.creat();
        if(departureAirport != null && !departureAirport.isEmpty()){
            builder.setDepartureAirport(departureAirport);
        }
        if(arrivalAirport != null && !arrivalAirport.isEmpty()){
            builder.setArrivalAirport(arrivalAirport);
        }
        FlightsFilter filterSaveToPage = builder.build();


        String scheduledDeparture = req.getParameter("scheduledDeparture");
        String scheduledArrival = req.getParameter("scheduledArrival");


       /* ZonedDateTime scheduledArrivalZone;
        ZonedDateTime scheduledDepartureZone;
        if(scheduledArrival != null){
           scheduledArrivalZone = ZonedDateTime.parse(scheduledArrival, ISO_ZONED_DATE_TIME);
        } else scheduledArrivalZone = null;

        if(scheduledDeparture != null){
            scheduledDepartureZone = ZonedDateTime.parse(scheduledArrival, ISO_ZONED_DATE_TIME);
        } else scheduledDepartureZone = null;*/

        String reqPage = req.getParameter("page");
        String reqSize = req.getParameter("size");
        int page1;
        int page = 1;
        if (reqPage != null && !reqPage.isEmpty()) {
            page1 = Integer.parseInt(reqPage);
            page = page + page1;
        }
        int size = 25;
        if (reqSize != null && !reqSize.isEmpty()) {
            size = Integer.parseInt(reqSize);
        }
        Page of = Page.of(size, page);



        FlightsFilter filter = FlightsFilter.Builder.creat()
                .setArrivalAirport(arrivalAirport)
                .setDepartureAirport(departureAirport)
                //.setScheduledArrival(scheduledArrivalZone)
                //.setScheduledDeparture(scheduledDepartureZone)
                .build();
        List<Flights> flights = flightsService.get(filter,of);
        req.setAttribute("flights",flights);
        req.setAttribute("filtersList",filtersList);
        req.setAttribute("filtersAll",filtersAll);
        req.setAttribute("departureAirport",filterSaveToPage.getDepartureAirport());
        req.setAttribute("arrivalAirport",filterSaveToPage.getArrivalAirport());

        req.getRequestDispatcher("/jsp/flights.jsp").forward(req,resp);
    }

}
