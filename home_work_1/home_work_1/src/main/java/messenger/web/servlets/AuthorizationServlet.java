package messenger.web.servlets;

import messenger.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AuthorizationServlet", urlPatterns = "/api/login")
public class AuthorizationServlet extends HttpServlet {
    private final String mainPage = "/ui";

    private final String signInUrl = "/ui/SignIn.jsp";
    private final UserService userService = new UserService();

    private static final String LOGIN = "login";

    private static final String PASSWORD = "password";
    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/http; charset=utf-8");

        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);

        if(!userService.isExist(login)){
            req.setAttribute("messageUserNoCreated", true);
            req.getRequestDispatcher(signInUrl).forward(req, resp);
        }

        if(userService.checkPassword(login,password)){
            HttpSession session = req.getSession();
            session.setAttribute("user",userService.getByLogin(login));
            resp.sendRedirect( req.getContextPath() + mainPage);
        } else {
            req.setAttribute("messageIncorrectPassword", true);
            req.getRequestDispatcher(signInUrl).forward(req,resp);
        }


    }

}
