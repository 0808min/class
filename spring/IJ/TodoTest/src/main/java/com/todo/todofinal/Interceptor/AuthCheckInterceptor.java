package com.todo.todofinal.Interceptor;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Log4j2
public class AuthCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {


        log.info("회원 로그인 여부 체크...");

        // session 확인
        HttpSession session = request.getSession(false);

        // 세션에 로그인 정보가 있으면 정상 처리 return true
        if(session != null && session.getAttribute("loginInfo") != null) {
            log.info("로그인 상태 ...");
            return true;
        }

        // 로그인 정보가 없으면 redirect:("/login") return false
        log.info("비로그인 상태 ...");
        response.sendRedirect("/login");
        return false;

        // 정상 처리가 되지 않도록 처리
//        return false;
//        정상처리
//        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
