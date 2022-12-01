package frost.countermobil.Polygon.filters;

import com.google.common.cache.Cache;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter (urlPatterns = "/delete")
public class CheckCSRFToken extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String token = req.getParameter("csrftoken");
        if (token != null) {
            HttpSession session = req.getSession();
            if (isTokenPresentInCache(token, session)) {
                chain.doFilter(req, res);
                return;
            }
        }
        res.sendError(401, "Token not valid");
    }

    private boolean isTokenPresentInCache(String token, HttpSession session) {
        Cache<String, Boolean> tokenCache = (Cache<String, Boolean>)
                session.getAttribute("cache");
        if (tokenCache == null) return false;
        return (tokenCache.getIfPresent(token) != null);
    }
}
