package frost.countermobil.Polygon.filters;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@WebFilter(urlPatterns = {"/storage", "/mystorage"})
public class GenerateCSRFToken extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpSession session = req.getSession();
        Cache<String, Boolean> tokenCache = getOrSetToken(session);
        String token = UUID.randomUUID().toString();
        tokenCache.put(token, true);
        req.setAttribute("csrftoken", token);
        System.out.println("token: " + token);
        chain.doFilter(req, res);

    }

    private Cache<String, Boolean> getOrSetToken(HttpSession session) {
        Cache<String, Boolean> tokenCache = (Cache<String, Boolean>)
                session.getAttribute("cache");
        if (tokenCache == null) {
            tokenCache = buildCache();
            session.setAttribute("cache", tokenCache);
        }
        return tokenCache;
    }

    private Cache<String, Boolean> buildCache() {
        return CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .build();
    }
}
