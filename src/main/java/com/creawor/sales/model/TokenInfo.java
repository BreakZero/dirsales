package com.creawor.sales.model;

/**
 * Created by Zero on 2017/3/10.
 *
 */
public class TokenInfo {
    private String token;
    private User user;

    public TokenInfo(String token, User user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
