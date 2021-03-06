package com.creawor.sales.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.creawor.sales.model.User;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

/**
 * Created by Zero on 2017/3/10.
 *
 */
@Service
public class AuthenticationService {
    public String getToken(User user) {
        String token = "";
        try {
            token = JWT.create()
                    .withAudience(user.getUserId())                     // 将 user id 保存到 token 里面
                    .sign(Algorithm.HMAC256(user.getPassword()));       // 以 password 作为 token 的密钥
        } catch (UnsupportedEncodingException ignore) {

        }
        return token;
    }
}
