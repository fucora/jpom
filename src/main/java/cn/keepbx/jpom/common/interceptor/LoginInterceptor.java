package cn.keepbx.jpom.common.interceptor;

import cn.jiangzeyin.common.interceptor.BaseInterceptor;
import cn.jiangzeyin.common.interceptor.InterceptorPattens;
import cn.keepbx.jpom.model.UserModel;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 *
 * @author jiangzeyin
 * Created by jiangzeyin on 2017/2/4.
 */
@InterceptorPattens
public class LoginInterceptor extends BaseInterceptor {

    public static final String SESSION_NAME = "user";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.preHandle(request, response, handler);
        HttpSession session = getSession();
        UserModel user = (UserModel) session.getAttribute(SESSION_NAME);
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            NotLogin notLogin = handlerMethod.getMethodAnnotation(NotLogin.class);
            if (notLogin == null) {
                if (user == null) {
                    response.sendRedirect(request.getContextPath() + "/login.html");
                    return false;
                }
            }
        }
        reload();
        return true;
    }
}
