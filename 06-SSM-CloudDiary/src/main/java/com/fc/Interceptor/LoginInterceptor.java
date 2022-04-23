package com.fc.Interceptor;

import com.fc.entity.TbUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    public String[] allowUrls; // 不拦截资源

    public void setAllowUrls(String[] allowUrls) {
        this.allowUrls = allowUrls;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       String uri = request.getRequestURI().replace(request.getContextPath(), "");
        TbUser user = (TbUser) request.getSession().getAttribute("user");
        if (user!=null){
            return true;
        }
        if (allowUrls!=null&&allowUrls.length>0){
            for (String allowUrl : allowUrls) {
                if (uri.contains(allowUrl)){
                    return true;
                }
            }
        }
        response.sendRedirect("/login.jsp");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
