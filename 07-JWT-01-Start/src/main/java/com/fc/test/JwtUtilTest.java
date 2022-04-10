package com.fc.test;

import com.fc.util.JwtUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JwtUtilTest {
    @Test
    public void testCreate(){
        Map<String, Object> claim = new HashMap<>();

        claim.put("id",1);
        claim.put("username","易烊千玺");

        String token = JwtUtil.createToken(claim,System.currentTimeMillis()+1000 * 20);

        System.out.println(token);
    }

    @Test
    public void testParse(){
        Map<String, Object> map = JwtUtil.getClaim("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjbGFpbSI6eyJpZCI6MSwidXNlcm5hbWUiOiLmmJPng4rljYPnjroifSwiZXhwIjoxNjQ5MTE4Njk1fQ.TjksHv-BXTu1FpsC3UMsJSzbcFTJHzwwq4tnaHVOwSM");

        Set<Map.Entry<String, Object>> entries = map.entrySet();

        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry.getKey()+":"+entry.getValue());

        }
    }

}
