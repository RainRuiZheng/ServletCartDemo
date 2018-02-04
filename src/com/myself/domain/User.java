package com.myself.domain; 

/**
 * 用户类，用于封装用户登录信息
 * @author Jungor
 *
 */
public class User {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [" + username + ", " + password + "]";
    }

}