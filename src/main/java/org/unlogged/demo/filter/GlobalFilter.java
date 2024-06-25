package org.unlogged.demo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(3)
public class GlobalFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        req.setAttribute("Global", getGlobalFilterAdditive());
        chain.doFilter(request, response);
    }

    public String getGlobalFilterAdditive() {
        return "global-filter";
    }
}
