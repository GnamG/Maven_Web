package com.fc.util;

import org.jasypt.util.text.BasicTextEncryptor;

// 加密工具
public class JasyptUtil {
    public static void main(String[] args) {
        String username = "root";
        String password = "636454";

        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        // 设置盐值
        encryptor.setPassword("iopjklbnm");
        // 密码进行加密
        String newUsername = encryptor.encrypt(username);
        String newPassword = encryptor.encrypt(password);

        System.out.println("加密后的账号"+newUsername);
        System.out.println("加密后的密码"+newPassword);

    }
}
