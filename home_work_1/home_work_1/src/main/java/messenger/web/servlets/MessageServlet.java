package messenger.web.servlets;

import messenger.core.dto.Message;
import messenger.core.dto.User;
import messenger.service.MessageService;
import messenger.service.UserService;
import messenger.service.api.IMessageService;
import messenger.service.api.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(name ="MessageServlet", urlPatterns = "/api/message")
public class MessageServlet extends HttpServlet {
    private final static String TEXT_MESSAGE = "textMessage";
    private final static String RECIPIENT_LOGIN = "recipientLogin";
    private final IMessageService messageService;
    private final IUserService userService;
    private final String messagePutUrl = "/ui/user/MessageUser.jsp";

    public MessageServlet() {
        this.messageService = new MessageService();
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user =(User) session.getAttribute("user");
        String userLogin = user.getLogin();
        List<Message> messages = messageService.getMessageRecipient(userLogin);

        req.setAttribute("messages", messages);
        req.getRequestDispatcher("/ui/user/Chats.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User autor = (User) session.getAttribute("user");

        String autorLogin = autor.getLogin();
        String recipientLogin = req.getParameter(RECIPIENT_LOGIN);
        String textMessage = req.getParameter(TEXT_MESSAGE);

        User recipientUser = userService.getByLogin(recipientLogin);

        if (recipientUser != null) {
            Message message = new Message(LocalDateTime.now(),autorLogin,recipientLogin,textMessage);
            messageService.creatMessage(message);
        } else {
            req.setAttribute("messageWrongUser", true);
        }
        req.getRequestDispatcher(messagePutUrl).forward(req, resp);
    }
}
