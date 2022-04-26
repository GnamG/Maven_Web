package com.fc;

import com.fc.entity.User;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringAppcationTest {
    @Autowired
    private User user;

    @Test
    @Tag("直男")
    void test(){
        System.out.println(user);
    }
}
