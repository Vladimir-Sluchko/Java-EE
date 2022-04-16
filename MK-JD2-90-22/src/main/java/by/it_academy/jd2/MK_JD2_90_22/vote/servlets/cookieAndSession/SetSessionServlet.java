package by.it_academy.jd2.MK_JD2_90_22.vote.servlets.cookieAndSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SetSessionServlet", urlPatterns = "/setsession")
public class SetSessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        HttpSession session = req.getSession();

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        if(firstName != null && lastName != null){
            session.setAttribute("Name",firstName + " : " + lastName);
        }else {
            if(session.getAttribute("Name") == null){
                throw new IllegalArgumentException("Нет данных");
            }
            PrintWriter writer = resp.getWriter();
            String str = (String) session.getAttribute("Name");
            writer.write(str);
        }
    }
}
