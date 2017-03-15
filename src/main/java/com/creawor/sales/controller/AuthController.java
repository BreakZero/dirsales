package com.creawor.sales.controller;

import com.creawor.sales.business.user.UserService;
import com.creawor.sales.common.RestResult;
import com.creawor.sales.common.RestResultGenerator;
import com.creawor.sales.model.TokenInfo;
import com.creawor.sales.model.User;
import com.creawor.sales.token.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Zero on 2017/3/10.
 *
 */
@RestController
@RequestMapping("/api/authentication")
public class AuthController {
    private AuthenticationService authenticationService;
    private UserService userService;

    @Autowired
    public AuthController(AuthenticationService authenticationService, UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @PostMapping("")
    public RestResult<TokenInfo> login(@RequestParam String account, @RequestParam String password) {
        User loginUser = userService.findOne(account, password);
        if (loginUser == null) {
            return RestResultGenerator.genErrorResult("用户不存在！");
        } else {
            String token = authenticationService.getToken(loginUser);
            return RestResultGenerator.genSuccessResult(new TokenInfo(token, loginUser));
        }
    }
}
