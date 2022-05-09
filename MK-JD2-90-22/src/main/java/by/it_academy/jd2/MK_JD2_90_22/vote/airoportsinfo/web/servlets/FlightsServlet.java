package by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.web.servlets;

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
import java.util.List;

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
        req.setAttribute("filtersList",filtersList);

        //String scheduledDeparture = req.getParameter("scheduledDeparture");
        String departureAirport = req.getParameter("departureAirport");
        //String scheduledArrival = req.getParameter("scheduledArrival");
        String arrivalAirport = req.getParameter("arrivalAirport");
        FlightsFilter filter = FlightsFilter.Builder.creat()
                .setArrivalAirport(arrivalAirport)
                .setDepartureAirport(departureAirport).build();
                //.setScheduledArrival()
                //.setScheduledDeparture().build();
        List<Flights> flights = flightsService.getAll(filter);
        req.setAttribute("flights",flights);
        req.getRequestDispatcher("/jsp/flights.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/http; charset=utf-8");
        /*String scheduledDeparture = req.getParameter("scheduledDeparture");
        String departureAirport = req.getParameter("departureAirport");
        String scheduledArrival = req.getParameter("scheduledArrival");
        String arrivalAirport = req.getParameter("arrivalAirport");


        FlightsFilter filter = FlightsFilter.Builder.creat()
                .setArrivalAirport(arrivalAirport).
                setDepartureAirport(departureAirport).
                setDepartureAirport(departureAirport).
                setArrivalAirport(arrivalAirport).build();
        List<Flights> flights = flightsService.getAll(filter);
        resp.sendRedirect( req.getContextPath() + "/flights");*/
    }
}
