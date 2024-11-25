package az.azure.manage.component;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * @author Az
 * @date 2023/12/26
 */
@Component
public class MyHandlerInterceptor implements HandlerInterceptor {

//    private static final Pattern SHOULD_NOT_FILTER_URL;
    private static final Pattern SHOULD_FILTER_URL;

    static {
        ArrayList<String> urlList = Lists.newArrayList();
        // 将不走拦截器的请求存放到Pattern
        urlList.add("(socket/.*)");
        urlList.add("(/user/test)");
        StringBuilder sb = new StringBuilder();
        for (String url : urlList) {
            sb.append(url);
            sb.append("|");
        }
        // cut off the last '|'
        sb.setLength(sb.length() - 1);
//        SHOULD_NOT_FILTER_URL = Pattern.compile(sb.toString());
        SHOULD_FILTER_URL = Pattern.compile(sb.toString());
    }


    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
   /* @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        // get the request url
        String servletPath = request.getServletPath();
        // ignore the not filter url
        if(SHOULD_NOT_FILTER_URL.matcher(servletPath).find()){
            System.out.println("=======in the matcher========");
            return true;
        }
        if(session.getAttribute("user") != null){
            String token = request.getHeader("access_token");
            // valid token
            // ...

            return true;
        }
        return false;
    }*/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        // get the request url
        String servletPath = request.getServletPath();
        // ignore the not filter url
        if(SHOULD_FILTER_URL.matcher(servletPath).find()){
            System.out.println("=======in the matcher========");
            return false;
        }
        if(session.getAttribute("user") != null){
            String token = request.getHeader("access_token");
            // valid token
            // ...

            return false;
        }
        return true;
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
