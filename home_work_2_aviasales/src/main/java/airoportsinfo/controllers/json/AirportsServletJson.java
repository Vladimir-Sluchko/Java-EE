package airoportsinfo.controllers.json;



import airoportsinfo.dao.dto.AirportInfo;
import airoportsinfo.service.AirportService;
import airoportsinfo.service.api.IAirportService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AirportsServletJson", urlPatterns = "/json/airports")
public class AirportsServletJson extends HttpServlet {
    IAirportService service;
    private ObjectMapper mapper = new ObjectMapper();


    public AirportsServletJson() {
        this.service = AirportService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        String sort = req.getParameter("sort");
        this.service.setSort(sort);
        List<AirportInfo> airportList = this.service.getAll();
        req.setAttribute("airportList",airportList );

        String json = mapper.writeValueAsString(airportList);

        writer.write(json);

        //req.getRequestDispatcher("/jsp/airports.jsp").forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/http; charset=utf-8");

        //resp.sendRedirect( req.getContextPath() + "/airports");
    }
}
