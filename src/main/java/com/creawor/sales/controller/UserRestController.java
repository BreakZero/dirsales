package com.creawor.sales.controller;


import com.creawor.sales.annotation.CurrentUser;
import com.creawor.sales.annotation.LoginRequired;
import com.creawor.sales.business.user.IUserService;
import com.creawor.sales.common.RestResult;
import com.creawor.sales.common.RestResultGenerator;
import com.creawor.sales.common.utils.Md5Utils;
import com.creawor.sales.model.TokenInfo;
import com.creawor.sales.model.User;
import com.creawor.sales.token.AuthenticationService;
import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jin_ on 2016/11/10.
 *
 */
@RestController(value = "/api/user")
@RequestMapping("/api/user")
public class UserRestController {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(UserRestController.class.getSimpleName());

    @Autowired
    private IUserService userService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("login")
    public RestResult<TokenInfo> login(@RequestParam String account, @RequestParam String password) {
        User loginUser = userService.findOne(account, password);
        if (loginUser == null) {
            return RestResultGenerator.genErrorResult("账号或密码错误！");
        } else {
            String token = authenticationService.getToken(loginUser);
            return RestResultGenerator.genSuccessResult(new TokenInfo(token, loginUser));
        }
    }

    @LoginRequired
    @PostMapping("resetPassword")
    public RestResult<String> resetPassword(@CurrentUser User user,
                                            @RequestParam("password") String password) {
        String pass = Md5Utils.encoderByMd5(password);
        if (StringUtils.equals(user.getPassword(), pass)) {
            return RestResultGenerator.genErrorResult("新密码跟旧密码不能一样");
        }
        try {
            user.setPassword(pass);
            userService.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return RestResultGenerator.genErrorResult("修改密码失败");
        }
        return RestResultGenerator.genSuccessResult("修改密码成功");
    }

    @PostMapping("refreshToken")
    public RestResult<String> refresh(@RequestParam String account, @RequestParam String password) {
        User loginUser = userService.findOne(account, password);
        if (loginUser == null) {
            return RestResultGenerator.genErrorResult("账号可能被销毁，请重新登录");
        } else {
            String token = authenticationService.getToken(loginUser);
            return RestResultGenerator.genSuccessResult(token);
        }
    }
}
