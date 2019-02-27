package com.ruiruisun.stock.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.ruiruisun.stock.bean.UserBean;
import com.ruiruisun.stock.entity.User;
import com.ruiruisun.stock.exception.NotFoundException;
import com.ruiruisun.stock.service.UserService;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.rmi.ServerException;

@RestController
@RequestMapping("login")
public class LoginController {
    @Resource
    private UserService userService;

    @PostMapping("/index")
    public String index() {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            String token = JWT.create()
                    .withClaim("name", 123)
                    .withClaim("sex", "男")
                    .withIssuer("auth0")
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            return exception.getMessage();
            //Invalid Signing configuration / Couldn't convert Claims.
        }
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(@RequestBody UserBean UserBean) {
        System.out.println(UserBean);
        return UserBean.getUsername();
    }

    @RequestMapping("/user/{id}")
    @ResponseBody
    public ResponseEntity user(@PathVariable int id) throws Exception {
//        throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        if (null == null) {
            throw new NotFoundException("test");
        }
        return new ResponseEntity<Object>(userService.Sel(id), HttpStatus.NOT_FOUND);
    }
}
