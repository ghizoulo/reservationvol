package reservation.security;

import reservation.model.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author Ghizlane
 */
public class SessionInterceptor extends HandlerInterceptorAdapter{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("loggedUser");
        if(user!=null)
            return true;
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/authentication.htm"));
        return false;
    }
}
