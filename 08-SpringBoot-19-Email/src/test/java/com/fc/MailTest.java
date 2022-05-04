package com.fc;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@SpringBootTest
public class MailTest {
    // java的邮件发送器
    @Autowired
    private JavaMailSender sender;

    @Test
    void testHtmlMail(){
        String context = "<img src='https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fweixin.sanbiaoge.com%2Fcunchu5%2F2021-02-07%2F4_16126366717967458.jpg&refer=http%3A%2F%2Fweixin.sanbiaoge.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1653634698&t=d7f6f0d2fd6e790edcbc0e2cb14a6115' alt='图片'/><font align='center' color='red'>欧阳xx，28岁嫁夫港商，因夫无法生育，为继承家业，想寻健康男士与我共孕，通话谈好，飞你处见面首付定金50万，电话1383838382</font>";

        // 创建一个复杂邮箱消息对象
        MimeMessage mimeMessage = sender.createMimeMessage();

        // 创建一个帮助类对象
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        try {
            helper.setFrom("635702657@qq.com");

            // 设置接受者
            helper.setTo("2904937506@qq.com");

            // 设置抄送人
            helper.setCc("1977331678@qq.com");

            // 设置主题
            helper.setSubject("重金求子");

            // 设置内容
            helper.setText(context, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        // 发送邮件
        sender.send(mimeMessage);
    }

    // 测试简单消息邮件
    @Test
    void contextLoads() {
        // 简单消息邮件
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        // 设置发送人
        simpleMailMessage.setFrom("635702657@qq.com");

        // 设置接收人
        simpleMailMessage.setTo("2937753364@qq.com", "3335939034@qq.com", "412790423@qq.com");

        // 设置主题
        simpleMailMessage.setSubject("面试offer");

        // 设置邮件的内容
        simpleMailMessage.setText("你好，我是秦始皇，其实我并没有死！我在西安有 100 亿吨黄金，我现在只需 100 元人民币来解冻我在西安的黄金！你微信、支付宝转给我都可以，账号就是我的手机号！转过来我直接带兵打过去，让你统领三军！");

        // 设置抄送
        simpleMailMessage.setCc("3335939034@qq.com");

        // 设置发送的日期
        simpleMailMessage.setSentDate(new Date());

        // 设置私密抄送人
        simpleMailMessage.setBcc("2937753364@qq.com");

        try {
            // 通过发送者，需要一个消息对象，直接发送邮件即可
            sender.send(simpleMailMessage);
        } catch (Exception e) {
            System.out.println("发送失败：" + e);
        }
    }
}
