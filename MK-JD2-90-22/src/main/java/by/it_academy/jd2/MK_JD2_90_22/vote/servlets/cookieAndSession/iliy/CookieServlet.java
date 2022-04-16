package by.it_academy.jd2.MK_JD2_90_22.vote.servlets.cookieAndSession.iliy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static by.it_academy.jd2.MK_JD2_90_22.vote.service.cookieAndSession.SetCookiesService.getValueFromAnywhere;
import static by.it_academy.jd2.MK_JD2_90_22.vote.service.cookieAndSession.SetCookiesService.saveCookies;

@WebServlet(name ="CookieServlet", urlPatterns = "/cookieservletnew")
public class CookieServlet extends HttpServlet {
    private static final String FIRST_NAME_PARAMETR_NAME = "firstname";
    private static final String LAST_NAME_PARAMETR_NAME = "lastname";

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        String firstNameVal = getValueFromAnywhere(req, FIRST_NAME_PARAMETR_NAME);
        saveCookies(resp,FIRST_NAME_PARAMETR_NAME,firstNameVal);

        String lastNameVal =getValueFromAnywhere(req,LAST_NAME_PARAMETR_NAME);
        saveCookies(resp,LAST_NAME_PARAMETR_NAME,lastNameVal);
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<p><span style='color: red;'> Hello, " + lastNameVal + " " + firstNameVal + "!</span></p>");
    }
}
