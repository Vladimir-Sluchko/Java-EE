package messenger.web.servlets;

import messenger.service.MessageService;
import messenger.service.StatisticService;
import messenger.service.UserService;
import messenger.service.api.IMessageService;
import messenger.service.api.IStatisticService;
import messenger.service.api.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StatisticsServlet", urlPatterns = "/ui/admin/statistics")
public class StatisticsServlet extends HttpServlet {
    private final IMessageService messageService;

    private final IUserService userService;
    private final IStatisticService statisticService;

    public StatisticsServlet() {
        this.messageService = new MessageService();
        this.userService = new UserService();
        this.statisticService = StatisticService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        int userCount = userService.getCount();
        int messageCount = messageService.getCount();
        int sessionCount = statisticService.getCounter();

        req.setAttribute("usersCount",userCount);
        req.setAttribute("messagesCount",messageCount);
        req.setAttribute("sessionsCount", sessionCount);
        req.getRequestDispatcher("/ui/admin/Statistics.jsp").forward(req, resp);

    }
}
