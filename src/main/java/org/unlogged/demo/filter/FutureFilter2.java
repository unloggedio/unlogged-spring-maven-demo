package org.unlogged.demo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
//@Order(2)
public class FutureFilter2 implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("Future Filter-2");
        System.out.println("Got a request for URL : " + req.getRequestURI());
        System.out.println("Future Filter 1 additive : " + req.getAttribute("F1Add"));
        req.setAttribute("F2Add", getFilter2String());
        chain.doFilter(request, response);
    }

    public String getFilter2String() {
        return "future-filter-2-additive";
    }
}
