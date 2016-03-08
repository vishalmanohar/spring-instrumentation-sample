package sample.data.jpa.insight;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import sample.data.jpa.insight.model.CurrentRequestLog;
import sample.data.jpa.insight.model.RequestLog;
import sample.data.jpa.insight.model.RequestLogs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

class SpringInsightMVCInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        CurrentRequestLog.start(request.getRequestURI());
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        Optional<RequestLog> requestLog = CurrentRequestLog.get();
        if(requestLog.isPresent()) {
            RequestLogs.addLog(requestLog.get());
            CurrentRequestLog.remove();
        }
    }
}