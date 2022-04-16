package by.it_academy.jd2.MK_JD2_90_22.vote.jsp.servlets;

import by.it_academy.jd2.MK_JD2_90_22.vote.jsp.service.NameGeneratorServive;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "HelloServlet", urlPatterns = "/test/hello1")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("name", NameGeneratorServive.getRandomName());

        req.getRequestDispatcher("/jsp/Hello.jsp").forward(req,resp);
    }
}
