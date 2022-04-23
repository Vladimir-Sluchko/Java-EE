package messenger.web.servlets;

import messenger.service.UserService;
import messenger.service.api.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="RegistrationServlet", urlPatterns = "/api/user")
public class RegistrationServlet extends HttpServlet {
    private final String signUpUrl = "/ui/SignUp.jsp";

    private final IUserService userService = new UserService();
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String FULL_NAME = "fullName";
    private static final String DATE_OF_BIRTH = "dateOfBirth";
    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/http; charset=utf-8");

        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
        String fullName = req.getParameter(FULL_NAME);
        String dateOfBirth = req.getParameter(DATE_OF_BIRTH);


        if (login.isEmpty() || password.isEmpty() || fullName.isEmpty() || dateOfBirth.isEmpty()) {
            req.setAttribute("messageOfEmpty", true);
            req.getRequestDispatcher(signUpUrl).forward(req, resp);
        }
        if (userService.isExist(login)) {
            req.setAttribute("userCreated", true);
            req.getRequestDispatcher(signUpUrl).forward(req, resp);
        } else {
            userService.createUser(login,password,fullName,dateOfBirth);
            resp.sendRedirect( req.getContextPath() + "/ui/signIn");
            }
    }

}
