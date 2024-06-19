package org.unlogged.demo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
//@Order(1)
public class FutureFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("Future Filter-1");
        System.out.println("Got a request for URL : " + req.getRequestURI());
        System.out.println("Auth Type : " + req.getAuthType());
        req.setAttribute("F1Add", getFilter1String());
        chain.doFilter(request, response);
    }

    public String getFilter1String() {
        return "future-filter-1-additive";
    }
}

