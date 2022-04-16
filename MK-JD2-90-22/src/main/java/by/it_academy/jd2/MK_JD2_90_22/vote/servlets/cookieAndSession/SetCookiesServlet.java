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

@WebServlet(name = "SetCookiesServlet", urlPatterns = "/setcookie")
public class SetCookiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        if(firstName != null && lastName != null){
            Cookie myCookie = new Cookie(firstName, lastName);
            myCookie.setMaxAge(60*60);
            resp.addCookie(myCookie);
        }else {
            if(req.getCookies() == null){
                throw new IllegalArgumentException("Нет Cookies");
            }
            Cookie[] cookies = req.getCookies();


            PrintWriter writer = resp.getWriter();

            for (Cookie cookie : cookies) {
                writer.println("<h1>" + "Hello, " + cookie.getName()+ " : " + cookie.getValue() + "</h1>");
            }

        }
    }
}
