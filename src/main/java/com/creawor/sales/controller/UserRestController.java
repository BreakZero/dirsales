package com.creawor.sales.controller;



import com.creawor.sales.business.user.IUserService;
import com.creawor.sales.common.RestResult;
import com.creawor.sales.common.RestResultGenerator;
import com.creawor.sales.model.TokenInfo;
import com.creawor.sales.model.User;
import com.creawor.sales.token.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jin_ on 2016/11/10.
 *
 */
@RestController
@RequestMapping("/api/user")
public class UserRestController {

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
