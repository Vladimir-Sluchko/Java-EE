package by.it_academy.jd2.MK_JD2_90_22.vote.servlets.voteServlet;

import by.it_academy.jd2.MK_JD2_90_22.vote.service.vote.controllert.html.GenreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet(name = "GenresServlet", urlPatterns = "/vote/genre")
public class GenresServlet extends HttpServlet {

    private GenreService service;

    public GenresServlet() {
        this.service = new GenreService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();

        List<String> genres = service.getGenres();

        int index = 1;
        for(String genre : genres){
            writer.write("<p>" + index++ + " - " + genre + "</p></br>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        service.add(req.getParameter("genre"));
    }
}
