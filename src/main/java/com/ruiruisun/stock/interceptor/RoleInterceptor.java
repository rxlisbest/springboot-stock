package com.ruiruisun.stock.interceptor;

import com.ruiruisun.stock.entity.UserRole;
import com.ruiruisun.stock.exception.UnauthorizedException;
import com.ruiruisun.stock.service.UserRoleService;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class RoleInterceptor implements HandlerInterceptor {

    @Resource
    private UserRoleService userRoleService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String uri = httpServletRequest.getRequestURI();
        String[] uriArray = uri.split("/");
        uri = uriArray[1] + "/" + uriArray[2];
        int user_id = (int) httpServletRequest.getAttribute("user_id");
        List<UserRole> userRoleList = userRoleService.findUserApiRole(user_id, uri);
        if (userRoleList == null || userRoleList.size() == 0) {
            throw new UnauthorizedException("无权限访问");
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