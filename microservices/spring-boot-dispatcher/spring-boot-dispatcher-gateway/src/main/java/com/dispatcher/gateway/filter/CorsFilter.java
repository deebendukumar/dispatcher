package com.dispatcher.gateway.filter;

import com.dispatcher.gateway.config.Constant;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class CorsFilter extends OncePerRequestFilter {

    @Value("${spring.security.cors.allowed-origins}")
    private List<String> allowedDomains;

    /**
     * basically here we are adding origin received in response header to allow CORS
     *
     * @param request
     * @param response
     * @param filterChain
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logger.info("status code: " + response.getStatus());
        String origin = request.getHeader(Constant.HTTP_HEADER_ORIGIN);
//        response.setHeader("Access-Control-Allow-Origin", origin);
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        response.addIntHeader("Access-Control-Max-Age", 10);
//        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
//        response.addHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
//        response.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Credentials");
//        if (!allowedDomains.isEmpty() && allowedDomains.contains(origin)) {
//            response.setStatus(HttpServletResponse.SC_OK);
//        } else {
//            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//        }
        filterChain.doFilter(request, response);
    }
}
