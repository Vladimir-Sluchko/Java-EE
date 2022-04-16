package by.it_academy.jd2.MK_JD2_90_22.vote.servlets.voteServlet;

import by.it_academy.jd2.MK_JD2_90_22.vote.core.dto.VoteDto;
import by.it_academy.jd2.MK_JD2_90_22.vote.service.vote.VoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "VoteServlet", urlPatterns = "/vote")
public class VoteServlet extends HttpServlet {
    private VoteService service;

    public VoteServlet() {
        this.service = new VoteService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        int artist = Integer.parseInt(req.getParameter("artist")) - 1;
        int[] genre = Arrays.stream(req.getParameterMap().get("genre"))
                .mapToInt(s->Integer.parseInt(s) - 1)
                .toArray();

        String about = req.getParameter("about");

        VoteDto vote = new VoteDto(artist,genre,about);
        service.save(vote);
    }

}
