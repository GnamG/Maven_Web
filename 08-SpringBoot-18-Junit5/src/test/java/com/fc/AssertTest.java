package com.fc;

import com.fc.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;

@DisplayName("断言测试")
public class AssertTest {
    @Autowired
    private User user;
    @Autowired
    private User user1;

    int count(int a,int b){
        return a+b;
    }

    @Test
    void testAdd(){
        int count = count(1,2);
        Assertions.assertEquals(4,count);
    }

    @Test
    void testEquals(){

        Assertions.assertEquals(new Object(),new Object(),"不是同一个对象");
        Assertions.assertEquals(user,user1);

    }
    @Test
    void testArray(){
        Assertions.assertArrayEquals(new int[]{1,2},new int[]{1,3},"不是同一个数组！");
    }

    @Test
    @Disabled("测试组合断言")
    void testAll(){
        Assertions.assertAll("测试组合断言",()->Assertions.assertNull(user1,"是Nu  ll嘛？"),
                ()->{
            int count = count(1,2);
            Assertions.assertEquals(4,count,"算术都不会，垃圾");
                },
                ()->Assertions.assertNotEquals(new Object(),new Object(),"你们的老婆同一个？"));
    }


    @DisplayName("异常断言测试")
    @Test
    void testException(){
        Assertions.assertThrows(ArithmeticException.class,()->{
            System.out.println(1/0);

        },"居然能运行？？");

    }
    @Test
    @DisplayName("测试超时断言")
    void testTimeout(){
        Assertions.assertTimeout(Duration.ofSeconds(4L),()->{
            Thread.sleep(3000);
        },"您的订单已超时！！！");
    }
    @Test
    @DisplayName("测试快速失败")
    void shouldFail(){
        Assertions.fail("失败了！！");
    }
}
