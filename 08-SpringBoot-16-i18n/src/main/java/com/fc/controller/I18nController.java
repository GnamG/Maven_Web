package com.fc.controller;

import com.fc.utils.MessageUtil;
import com.fc.vo.LoginPageVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.MessageUtils;

@RestController
@RequestMapping("i18n")
public class I18nController {

    @RequestMapping("get")
    public LoginPageVo get(){
        LoginPageVo locale = new LoginPageVo();
        locale.setLogin(MessageUtil.get("login"));
        locale.setPassword(MessageUtil.get("password"));
        locale.setUsername(MessageUtil.get("username"));
        locale.setWelcome(MessageUtil.get("welcome"));
        locale.setTitle(MessageUtil.get("title"));
        locale.setRememberMe(MessageUtil.get("rememberMe"));
        return locale;
    }
}
