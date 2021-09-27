package com.rehnemacollege.backend.configuration;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RequestResponseLoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if (!(request instanceof HttpServletRequest) || !(response instanceof HttpServletResponse))
            throw new ServletException("RequestResponseLoggingFilter just supports HTTP requests");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        System.out.println("Logging Request: " + req.getMethod() + " " + req.getRequestURI());

        chain.doFilter(request, response);

        System.out.println("Logging Response:" + res.getContentType());
    }
}
