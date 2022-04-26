package com.fc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("前置条件")
public class AssumptionTest {
    private final String environment = "true";

    @Test
    @DisplayName("简单条件")
    void testSimpleAssume(){
        Assertions.assertFalse(()->this.environment.equals("test"));
    }

    @Test
    @DisplayName("Then do")
    void testThenDo(){
//        Assertions.assumingThat(this.environment.equals("dev"),()->{
//            System.out.println("当前环境是测试环境");
//        });
    }

}
