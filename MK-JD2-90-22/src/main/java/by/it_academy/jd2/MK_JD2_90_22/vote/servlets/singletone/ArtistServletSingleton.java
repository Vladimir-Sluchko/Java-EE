package by.it_academy.jd2.MK_JD2_90_22.vote.servlets.singletone;

import by.it_academy.jd2.MK_JD2_90_22.vote.service.singleton.ArtistSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ArtistServletSingleton", urlPatterns = "/vote1/artistsingleton")
public class ArtistServletSingleton extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();

        List<String> artists = ArtistSingleton.getArtistSingleton().getArtists();

        int index = 1;
        for(String artist : artists){
            writer.write("<p>" + index++ + " - " + artist + "</p></br>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

       ArtistSingleton.getArtistSingleton().addArtist(req.getParameter("artist"));

    }
}
