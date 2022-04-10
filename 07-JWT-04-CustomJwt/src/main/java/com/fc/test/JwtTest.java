package com.fc.test;

import com.fc.util.JwtUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JwtTest {
    @Test
    public void testGetToken() {
        Map<String, Object> claim = new HashMap<>();
        claim.put("username","易烊千玺");
        String token = JwtUtil.getToken(claim,"yyqx");
        System.out.println(token);
    }

    @Test
    public void testVerifyToken(){
        Map<String, Object> result = JwtUtil.verify("eyJhbGciOiAiSFMyNTYifQ==.eyJleHAiOjE2NDkyMjI3NTMwMTYsImlhdCI6MTY0OTIyMjczMzAxNiwidXNlcm5hbWUiOiLmmJPng4rljYPnjroifQ==.9912ffff5cd0f48d973bb77bb7f0bb0f", "yyqx");

        Set<Map.Entry<String, Object>> entries = result.entrySet();

        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }

}
