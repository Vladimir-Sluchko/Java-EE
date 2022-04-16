package by.it_academy.jd2.MK_JD2_90_22.vote.servlets.cookieAndSession.iliy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static by.it_academy.jd2.MK_JD2_90_22.vote.service.cookieAndSession.SetSessionService.getValueFromAnywhere2;
import static by.it_academy.jd2.MK_JD2_90_22.vote.service.cookieAndSession.SetSessionService.saveSession;

@WebServlet(name = "SessionServlet", urlPatterns = "/sessionservletnew")
public class SessionServlet extends HttpServlet {
    private static final String FIRST_NAME_PARAMETR_NAME = "firstname";
    private static final String LAST_NAME_PARAMETR_NAME = "lastname";

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        String firstNameVal = getValueFromAnywhere2(req, FIRST_NAME_PARAMETR_NAME);
        saveSession(req,FIRST_NAME_PARAMETR_NAME,firstNameVal);

        String lastNameVal = getValueFromAnywhere2(req,LAST_NAME_PARAMETR_NAME);
        saveSession(req,LAST_NAME_PARAMETR_NAME,lastNameVal);
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter writer = resp.getWriter();

        writer.write("<h1>" +   "</h1>");
        writer.write("<p><span style='color: red;'> Hello, " + lastNameVal +
                " " + firstNameVal + "!</span></p>");
    }
}
