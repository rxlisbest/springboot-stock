package com.ruiruisun.stock.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.ruiruisun.stock.bean.UserBean;
import com.ruiruisun.stock.entity.User;
import com.ruiruisun.stock.exception.NotFoundException;
import com.ruiruisun.stock.service.UserService;
import com.ruiruisun.stock.util.LocaleMessageUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("login")
public class LoginController {
    @Resource
    private UserService userService;

    @PostMapping("/index")
    public String index(String username, String password) throws Exception  {

        String msg3 = LocaleMessageUtil.getMsg("welcome");
        System.out.println(msg3);

        User user = userService.findByUsername(username);
        if (user == null) {
            throw new NotFoundException("用户不存在");
        }
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
        return new ResponseEntity<Object>(userService.findByUsername(id + ""), HttpStatus.NOT_FOUND);
    }
}
