package com.ruiruisun.stock.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.ruiruisun.stock.bean.UserBean;
import com.ruiruisun.stock.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
public class LoginController
{
    private UserService userService;

    @RequestMapping("/index")
    public String index(){
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            String token = JWT.create()
                    .withClaim("name", 123)
                    .withClaim("sex", "男")
                    .withIssuer("auth0")
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
            return "123";
        }
    }


    @RequestMapping("/test")
    @ResponseBody
    public String test(@RequestBody UserBean UserBean){
        System.out.println(UserBean);
        return UserBean.getUsername();
    }

    @RequestMapping("/user/{id}")
    public String user(@PathVariable int id){
        return userService.Sel(1).toString();
    }
}
