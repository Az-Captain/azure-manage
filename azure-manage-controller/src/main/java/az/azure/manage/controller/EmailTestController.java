package az.azure.manage.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author Az
 * @date 2024/6/12
 */
@RestController
@RequestMapping("/email")
@Slf4j
@Api(tags = "发送邮件测试")
public class EmailTestController {

    @Resource
    private JavaMailSender javaMailSender;

    @GetMapping("send")
    @ApiOperation("发送简单的邮件")
    public void sendSimpleMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("azt0903@163.com");
        message.setTo("741311930@qq.com");
        message.setSubject("主题：测试发送邮件功能");
        message.setText("测试邮件内容");
        javaMailSender.send(message);
    }

    @GetMapping("/send/file")
    @ApiOperation("发送带附件的邮件")
    public void sendAttachmentMail() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("azt0903@163.com");
        helper.setTo("741311930@qq.com");
        helper.setSubject("主题：测试发送邮件功能");
        helper.setText("测试邮件内容");

        FileSystemResource file = new FileSystemResource(new File("test.jpg"));
        helper.addAttachment("附件1-1", file);
        helper.addAttachment("附件1-2", file);

        javaMailSender.send(mimeMessage);
    }

    @GetMapping("/send/inline")
    @ApiOperation("发送嵌入文件的邮件")
    public void sendInlineMail() throws Exception {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("dyc87112@qq.com");
        helper.setTo("dyc87112@qq.com");
        helper.setSubject("主题：嵌入静态资源");
        helper.setText("<html><body><img src=\"cid:weixin\" ></body></html>", true);

        FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
        helper.addInline("weixin", file);

        javaMailSender.send(mimeMessage);

    }

}
