package jackson.web.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jackson.dto.Citizen;
import jackson.dto.Student;
import jackson.service.CitizenService;
import jackson.service.api.ICitizenService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Pageable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CitizensServlet", urlPatterns = "/сitizens")
public class CitizensServlet extends HttpServlet {
    private ICitizenService iCitizenService;
    private ObjectMapper mapper;

    public CitizensServlet() {
        this.iCitizenService = CitizenService.getInstance();
        this.mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter writer = resp.getWriter();

        List<Citizen> all = iCitizenService.getAll();
        String json = mapper.writeValueAsString(all);
        writer.write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Citizen citizen = mapper.readValue(req.getInputStream(),Citizen.class);
        iCitizenService.setCitizen(citizen);
    }
}
