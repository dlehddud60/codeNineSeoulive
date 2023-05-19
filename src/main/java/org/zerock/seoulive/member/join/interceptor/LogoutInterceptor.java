package org.zerock.seoulive.member.join.interceptor;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Log4j2
@NoArgsConstructor

@Component
public class LogoutInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
            throws Exception {
        log.trace("====================================================");
        log.trace("preHandle(req, res, {}) invoked.", handler);
        log.trace("====================================================");

        HttpSession session = req.getSession(false);
        if(session != null) {
            session.invalidate();
        } // if
        res.sendRedirect("/member/login/main");

        return false;
    } // preHandle
} // end class
