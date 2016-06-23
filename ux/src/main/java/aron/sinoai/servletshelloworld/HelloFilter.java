package aron.sinoai.servletshelloworld;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 */
public class HelloFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;

        HttpServletRequest httpServletRequest = (HttpServletRequest) req;

        final String requestURI = httpServletRequest.getRequestURI();

        if (!requestURI.contains("index.html")) {
            httpServletResponse.sendRedirect("index.html");
        } else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
