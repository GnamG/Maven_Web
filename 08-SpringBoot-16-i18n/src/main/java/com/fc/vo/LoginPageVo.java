package com.fc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginPageVo {
    private String title;
    private String welcome;
    private String username;
    private String password;
    private String rememberMe;
    private String Login;
}
