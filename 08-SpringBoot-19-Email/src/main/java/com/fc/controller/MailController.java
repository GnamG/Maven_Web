package com.fc.controller;

import com.fc.vo.MailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@RestController
@RequestMapping("mail")
public class MailController {
    @Autowired
    private JavaMailSender sender;

    @RequestMapping("send")
    public String send(MailVo vo, MultipartFile[] file){
        // 复杂类型的消息创造
        MimeMessage message = sender.createMimeMessage();

        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message,true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        try {
            helper.setFrom(vo.getFrom());
            helper.setCc(vo.getCc());
            helper.setBcc(vo.getBcc());
            helper.setText(vo.getContent());
            helper.setSubject(vo.getSubject());
            helper.setSentDate(new Date());
            if (file.length>0) {
                for (MultipartFile multipartFile : file) {
                    if (!multipartFile.isEmpty()&& multipartFile.getOriginalFilename()!=null){
                        helper.addAttachment(multipartFile.getOriginalFilename(),multipartFile);
                    }
                }
            }


            sender.send(message);
            return "发生成功";
        } catch (MessagingException e) {
            e.printStackTrace();
            return "发生失败";
        }
    }

}
