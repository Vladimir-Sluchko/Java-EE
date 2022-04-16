package by.it_academy.jd2.MK_JD2_90_22.vote.servlets.singletone;

import by.it_academy.jd2.MK_JD2_90_22.vote.service.singleton.GenrySingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "GenresServletSingleton", urlPatterns = "/vote1/genresingletone")
public class GenresServletSingleton extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();


        List<String> genres = GenrySingleton.getGenrySingleton().getGenres();

        int index = 1;
        for(String genre : genres){
            writer.write("<p>" + index++ + " - " + genre + "</p></br>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        GenrySingleton.getGenrySingleton().addGenre(req.getParameter("genre"));
    }
}
