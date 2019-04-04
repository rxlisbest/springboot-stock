package com.ruiruisun.stock.controller;

import com.ruiruisun.stock.bean.ChangePasswordUserBean;
import com.ruiruisun.stock.entity.User;
import com.ruiruisun.stock.exception.BadRequestException;
import com.ruiruisun.stock.exception.NotFoundException;
import com.ruiruisun.stock.service.UserService;
import com.ruiruisun.stock.utils.LocaleMessageUtils;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@ResponseBody
@RestController
@RequestMapping(value = "users")
public class UserController {
    @Resource
    private UserService userService;

    @PutMapping("/change_password/{id}")
    public int update(@RequestBody ChangePasswordUserBean request, @PathVariable int id) throws Exception {
        String oldPassword = request.getOldPassword();
        String password = request.getPassword();
        String confirmPassword = request.getConfirmPassword();
        if (oldPassword == null || oldPassword.length() == 0) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("user.old_password_empty"));
        }
        if (password == null || password.length() == 0) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("user.password_empty"));
        }
        if (confirmPassword == null || confirmPassword.length() == 0) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("user.confirm_password_empty"));
        }
        User user = userService.findOne(id);
        if (user == null) {
            throw new NotFoundException(LocaleMessageUtils.getMsg("user.not_exists"));
        }

        oldPassword = DigestUtils.md5DigestAsHex(oldPassword.getBytes());
        String passwordMd5 = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!oldPassword.equals(user.getPassword())) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("login.password_error"));
        }
        if (password.length() < 6) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("user.password_length_error"));
        }
        if (!password.equals(confirmPassword)) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("user.confirm_password_not_same"));
        }

        user.setPassword(passwordMd5);
        int rows = userService.update(user);
        return rows;
    }
}
