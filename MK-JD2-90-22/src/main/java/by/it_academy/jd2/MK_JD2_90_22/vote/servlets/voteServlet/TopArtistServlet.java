package by.it_academy.jd2.MK_JD2_90_22.vote.servlets.voteServlet;

import by.it_academy.jd2.MK_JD2_90_22.vote.service.vote.TopArtistService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "TopArtistServlet",urlPatterns = "/topartist")
public class TopArtistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        Map<String ,Integer> topArtist = TopArtistService.getInstance().getTopArtist();
        for (Map.Entry entry:topArtist.entrySet()) {
            writer.write("<p>" + entry.getKey() + " - " + entry.getValue() +  " количество голосов" +"</p> <br>");
        }
    }
}
