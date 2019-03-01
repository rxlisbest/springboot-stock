package com.ruiruisun.stock.controller;

import com.ruiruisun.stock.bean.AuthorizationBean;
import com.ruiruisun.stock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("goods_category")
public class GoodsCategoryController {
    @Resource
    private UserService userService;

    @GetMapping("/index")
    public String index(HttpServletRequest request) throws Exception {
        return "2";
    }
}
