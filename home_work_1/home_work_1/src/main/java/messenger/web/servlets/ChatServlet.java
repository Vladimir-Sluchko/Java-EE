package messenger.web.servlets;

import messenger.core.dto.Message;
import messenger.core.dto.User;
import messenger.service.MessageService;
import messenger.service.api.IMessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ChatServlet", urlPatterns = "/ui/user/chats")
public class ChatServlet extends HttpServlet {
    private final IMessageService messageService;

    public ChatServlet() {
        this.messageService = new MessageService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user =(User) session.getAttribute("user");
        String userLogin = user.getLogin();
        List<Message> messages = messageService.getMessageRecipient(userLogin);

        req.setAttribute("messages", messages);
        req.getRequestDispatcher("/ui/user/Chats.jsp").forward(req, resp);

    }
}
