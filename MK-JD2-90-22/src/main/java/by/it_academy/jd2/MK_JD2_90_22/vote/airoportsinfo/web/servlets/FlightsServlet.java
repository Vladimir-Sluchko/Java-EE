package by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.web.servlets;

import by.it_academy.jd2.MK_JD2_90_22.vote.airoportsinfo.dao.api.IFlightsFilter;
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
        this.flightsFilterService = new FlightsFilterService();
        this.flightsService = new FlightsService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String scheduledDeparture = req.getParameter("scheduledDeparture");
        String departureAirport = req.getParameter("departureAirport");
        String scheduledArrival = req.getParameter("scheduledArrival");
        String arrivalAirport = req.getParameter("arrivalAirport");
        FlightsFilter filter = FlightsFilter.Builder.builder()
                .setArrivalAirport(arrivalAirport).
                setDepartureAirport(departureAirport).
                setDepartureAirport(departureAirport).
                setArrivalAirport(arrivalAirport).build();

        List<Flights> flights = flightsService.get(filter);
        List<String> departureAirportList = flightsFilterService.getDistinct("departure_airport");
        List<String> arrivalAirportList = flightsFilterService.getDistinct("arrival_airport");
        req.setAttribute("departureAirportList",departureAirportList);
        req.setAttribute("arrivalAirportList",arrivalAirportList);

        req.setAttribute("flights",flights);
        req.getRequestDispatcher("/jsp/flights.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/http; charset=utf-8");
        String scheduledDeparture = req.getParameter("scheduledDeparture");
        String departureAirport = req.getParameter("departureAirport");
        String scheduledArrival = req.getParameter("scheduledArrival");
        String arrivalAirport = req.getParameter("arrivalAirport");


        FlightsFilter filter = FlightsFilter.Builder.builder()
                .setArrivalAirport(arrivalAirport).
                setDepartureAirport(departureAirport).
                setDepartureAirport(departureAirport).
                setArrivalAirport(arrivalAirport).build();
        List<Flights> flights = flightsService.get(filter);
        resp.sendRedirect( req.getContextPath() + "/flights");
    }
}
