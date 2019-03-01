package com.ruiruisun.stock.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.ruiruisun.stock.bean.AuthorizationBean;
import com.ruiruisun.stock.entity.User;
import com.ruiruisun.stock.exception.BadRequestException;
import com.ruiruisun.stock.exception.ForbiddenException;
import com.ruiruisun.stock.exception.InternalServerErrorException;
import com.ruiruisun.stock.exception.NotFoundException;
import com.ruiruisun.stock.service.UserService;
import com.ruiruisun.stock.utils.LocaleMessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("login")
public class LoginController {
    @Resource
    private UserService userService;

    @Autowired
    AuthorizationBean authorizationBean;

    @PostMapping("/index")
    public String index(HttpServletRequest request) throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || username.length() == 0) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("login.username_empty"));
        }
        if (password == null || password.length() == 0) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("login.password_empty"));
        }
        User user = userService.findByUsername(username);
        if (user == null) {
            throw new NotFoundException(LocaleMessageUtils.getMsg("login.user_without"));
        }

        String passwordMd5 = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!user.getPassword().equals(passwordMd5)) {
            throw new ForbiddenException(LocaleMessageUtils.getMsg("login.password_error"));
        }
        try {
            Algorithm algorithm = Algorithm.HMAC256(authorizationBean.getSecret());
            String token = JWT.create()
                    .withClaim("id", user.getId())
                    .withClaim("username", user.getUsername())
                    .withClaim("name", user.getName())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            throw new InternalServerErrorException(exception.getMessage());
        }
    }
}
