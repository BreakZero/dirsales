package com.creawor.sales.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.creawor.sales.annotation.LoginRequired;
import com.creawor.sales.business.user.UserService;
import com.creawor.sales.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

/**
 * Created by Zero on 2017/3/10.
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationInterceptor.class);

    @Autowired
    private UserService mUserService;

    @Bean
    public UserService getUserService() {
        return new UserService();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        long begin_nao_time = System.currentTimeMillis();
        request.setAttribute("begin_nao_time", begin_nao_time);

        String uri = request.getRequestURI();
        LOGGER.debug("URI ===》 " + uri);

        Map<String, String[]> map = request.getParameterMap();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            String[] values = map.get(key);
            for (String value : values) {
                LOGGER.debug("params ======》 " + key + " = " + value);
            }
        }

        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        // 判断接口是否需要登录
        LoginRequired methodAnnotation = method.getAnnotation(LoginRequired.class);
        // 有 @LoginRequired 注解，需要认证
        if (methodAnnotation != null) {
            // 执行认证
            String token = request.getHeader("token");  // 从 http 请求头中取出 token
            if (token == null) {
                throw new RuntimeException("没有Token，请先登录");
            }
            String userId;
            try {
                userId = JWT.decode(token).getAudience().get(0);  // 获取 token 中的 user id
            } catch (JWTDecodeException e) {
                throw new RuntimeException("Token无效，请重新登录");
            }
            User user = mUserService.findById(userId);
            if (user == null) {
                throw new RuntimeException("用户不存在");
            }
            // 验证 token
            try {
                JWTVerifier verifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
                try {
                    verifier.verify(token);
                } catch (JWTVerificationException e) {
                    throw new RuntimeException("Token无效，请重新登录");
                }
            } catch (UnsupportedEncodingException ignore) {
            }
            request.setAttribute("currentUser", user);
            return true;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long begin_nao_time = (Long) request.getAttribute("begin_nao_time");
        long interval = System.currentTimeMillis() - begin_nao_time;
        LOGGER.debug("响应时间 ===》 " + interval + "毫秒");
    }
}
