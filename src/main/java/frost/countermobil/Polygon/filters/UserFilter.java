package frost.countermobil.Polygon.filters;

import frost.countermobil.Polygon.models.User;
import frost.countermobil.Polygon.services.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;

import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/storage", "/draw", "/preview", "/mystorage"})
public class UserFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        UserService userService = new UserService();

        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("userName");
        if (userName == null) {
            res.sendRedirect("/login");
            return;
        }
        User user = userService.recoverUser(userName);
        //User does not exist in db previous method returns null value.
        //Then this user is created and an ID is assigned to it
        if (user == null) {
            user = new User();
            user.setUserName(userName);
            userService.newUser(user);
        }
        int userId = user.getId();
//        if (userId == null){
//            User user = new User();
//            userService.newUser(user);
//            userId = ""+user.getId();
//        }
        session.setAttribute("userId", userId);
        chain.doFilter(req, res);
    }
}
