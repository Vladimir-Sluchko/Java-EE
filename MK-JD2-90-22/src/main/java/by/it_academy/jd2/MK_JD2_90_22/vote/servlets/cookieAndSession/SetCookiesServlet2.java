package by.it_academy.jd2.MK_JD2_90_22.vote.servlets.cookieAndSession;

import by.it_academy.jd2.MK_JD2_90_22.vote.service.cookieAndSession.SetCookiesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SetCookiesServlet2", urlPatterns = "/setcookie3")
public class SetCookiesServlet2 extends HttpServlet {
    private SetCookiesService service;

   private SetCookiesServlet2() {
        this.service = new SetCookiesService();
    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
       /* req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        service.saveCookies(resp,firstName,lastName);
        service.getValue(req,firstName);*/

    }
}


 /* if(firstName != null && lastName != null){
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

        }*/