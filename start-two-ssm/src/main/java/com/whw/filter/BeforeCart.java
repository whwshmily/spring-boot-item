package com.whw.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter({"/category/initCart","/category/myCart"})
public class BeforeCart extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String uri = req.getRequestURI();
//        uri = uri.substring(uri.indexOf("localhost/")+9);
        String queryString = req.getQueryString();
       if (queryString!=null){
           uri = uri+"?"+queryString;
       }
        Object user = req.getSession().getAttribute("user");
       if (user == null){
           req.getSession().setAttribute("url",uri);
           res.sendRedirect("/login.jsp");
       }else {
           chain.doFilter(req,res);
       }
    }
}
