package com.og.co2data.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "AuthFilter", urlPatterns = { "*.xhtml" })
public class AuthorizationFilter extends HttpFilter {
    private FilterConfig config;

    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        try {

            HttpServletRequest reqt = (HttpServletRequest) req;
            HttpServletResponse resp = (HttpServletResponse) res;
            HttpSession ses = reqt.getSession(false);

            String reqURI = reqt.getRequestURI();
            if (reqURI.contains("login.xhtml")
                    || reqURI.contains("register.xhtml")
                    || reqURI.contains("home.xhtml")
                    || reqURI.contains("data.xhtml")
                    || reqURI.contains("contact.xhtml")
                    || reqURI.contains("impressum.xhtml")
                    || (ses != null && ses.getAttribute("username") != null))
                chain.doFilter(req, res);
            else
                resp.sendRedirect(reqt.getContextPath() + "/home.xhtml");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

    public void destroy() {
        config = null;
    }
}