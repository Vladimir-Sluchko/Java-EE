package messenger.web.filters;

import messenger.core.dto.Role;
import messenger.core.dto.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AdminSecurityFilter", urlPatterns = {"/ui/admin/*", "/api/admin/*"})
public class AdminSecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();

        if ((session != null) && (session.getAttribute("user") != null)) {
            User user = (User) session.getAttribute("user");

            if (user.getRole().equals(Role.ADMINISTRATOR)) {
                chain.doFilter(request, response);
            }
        }else {
            resp.sendRedirect(contextPath + "/ui/signIn");
            resp.sendRedirect(contextPath + "/");
            return;
        }
    }

    @Override
    public void destroy() {

    }

}
