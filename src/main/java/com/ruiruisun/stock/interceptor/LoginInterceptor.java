package com.ruiruisun.stock.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ruiruisun.stock.bean.AuthorizationBean;
import com.ruiruisun.stock.exception.BadRequestException;
import com.ruiruisun.stock.exception.UnauthorizedException;
import com.ruiruisun.stock.utils.LocaleMessageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class LoginInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
    private static final String paramHeader = "Authorization";
    private static final String paramParameter = "access_token";
    private static final String authorizationPrefix = "Bearer ";

    @Autowired
    AuthorizationBean authorizationBean;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String tokenHeader = httpServletRequest.getHeader(paramHeader);
        String tokenParameter = httpServletRequest.getParameter(paramParameter);
        if (tokenHeader == null && tokenParameter == null) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("login.authorization_empty"));
        }
        String token = null;
        if (tokenHeader != null) {
            token = tokenHeader.replace(authorizationPrefix, "");
        } else {
            token = tokenParameter;
        }
        try {
            Algorithm algorithm = Algorithm.HMAC256(authorizationBean.getSecret());
            JWTVerifier verifier = JWT.require(algorithm).build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
        } catch (JWTVerificationException exception){
            throw new UnauthorizedException(exception.getMessage());
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }

}