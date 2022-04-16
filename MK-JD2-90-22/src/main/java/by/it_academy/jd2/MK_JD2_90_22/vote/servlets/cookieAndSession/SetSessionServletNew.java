package by.it_academy.jd2.MK_JD2_90_22.vote.servlets.cookieAndSession;

import by.it_academy.jd2.MK_JD2_90_22.vote.service.cookieAndSession.SetSessionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SessionServletNew", urlPatterns = "/setsessionnew")
public class SetSessionServletNew extends HttpServlet {

    private SetSessionService service;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session2 = req.getSession();

    }
}
