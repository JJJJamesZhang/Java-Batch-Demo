package com.company.demojavabatch.filter;


import com.company.demojavabatch.utils.CacheClient;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*@Component
@WebFilter(urlPatterns = "/employee/*")*/
public class EmployeeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        String token = request.getHeader("token");
        String username = request.getHeader("username");
        JedisPool jedisPool = CacheClient.getJedisPool();
        try (Jedis jedis = jedisPool.getResource()){
            String cachedToken = jedis.get(username);
            if (cachedToken != null && token.equals(cachedToken)){
                filterChain.doFilter(servletRequest,servletResponse);
            }else {
                request.getRequestDispatcher("/loginError").forward(request,response);
            }
        }catch (Exception e){
            request.getRequestDispatcher("/loginError").forward(request,response);
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
