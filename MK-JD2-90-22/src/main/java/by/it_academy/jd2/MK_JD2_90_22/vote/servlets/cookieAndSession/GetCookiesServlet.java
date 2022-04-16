package by.it_academy.jd2.MK_JD2_90_22.vote.servlets.cookieAndSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

@WebServlet(name = "GetCookiesServlet", urlPatterns = "/getcookie")
public class GetCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        resp.setContentType("text/html; charset=utf-8");
        Cookie[] cookies = req.getCookies();

        PrintWriter writer =resp.getWriter();

        writer.println("<html>");
        for (Cookie cokie : cookies) {
            writer.println("<h1>" + cokie.getName()+ " : " + cokie.getValue() + "</h1>");
        }
        writer.println("</html>");
    }
}
