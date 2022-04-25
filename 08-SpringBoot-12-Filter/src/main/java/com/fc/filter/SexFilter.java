package com.fc.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
//@WebFilter("/*")
//@Component
// 指定注入到容器中的顺序
//@Order(-1)
public class SexFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤前：女的");

        filterChain.doFilter(request,response);
        System.out.println("过滤后：活的");
    }

    @Override
    public void destroy() {

    }
}
