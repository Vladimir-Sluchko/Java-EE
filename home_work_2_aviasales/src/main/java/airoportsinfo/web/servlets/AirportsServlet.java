package airoportsinfo.web.servlets;



import airoportsinfo.dao.dto.AirportInfo;
import airoportsinfo.service.AirportService;
import airoportsinfo.service.api.IAirportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AirportsServlet", urlPatterns = "/airports")
public class AirportsServlet extends HttpServlet {
    IAirportService service;

    public AirportsServlet() {
        this.service = AirportService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        String sort = req.getParameter("sort");
        this.service.setSort(sort);
        List<AirportInfo> airportList = this.service.getAll();
        req.setAttribute("airportList",airportList );



        req.getRequestDispatcher("/jsp/airports.jsp").forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/http; charset=utf-8");

        resp.sendRedirect( req.getContextPath() + "/airports");
    }
}
