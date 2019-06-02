package com.example.demo.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Component
public class AppRequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    // USED for application level header checks.
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        Enumeration<String> httpHeaderNames = httpRequest.getHeaderNames();

        HashMap<String,String> headers = new HashMap<>();
        if(httpHeaderNames != null) {
            while (httpHeaderNames.hasMoreElements()) {
                String  key = httpHeaderNames.nextElement();
                headers.put(key,httpRequest.getHeader(key));
            }
        }

        if(headers.get("basic-app-header") == null){
            throw new ServletException("Headder do not have basicAppHeader");
        }

        chain.doFilter(request,response);
    }


    @Override
    public void destroy() {

    }
}
