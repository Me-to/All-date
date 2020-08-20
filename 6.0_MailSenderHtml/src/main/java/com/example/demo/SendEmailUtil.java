package com.example.demo;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Properties;

@Component
public class SendEmailUtil {

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Value("${spring.mail.username}")
    private String username;
    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.password}")
    private String password;
    @Value("${spring.mail.default-encoding}")
    private String encoding;

    public void sendMail() throws MessagingException, IOException {

        javaMailSender.setUsername(username);
        javaMailSender.setPassword(password);
        javaMailSender.setHost(host);
        javaMailSender.setDefaultEncoding(encoding);

        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.exmail.qq.com");
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.connectiontimeout", "2000010");
        props.setProperty("mail.smtp.timeout", "20000");
        javaMailSender.setJavaMailProperties(props);

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setTo(new String[]{"694656210@qq.com"});
        helper.setFrom("zhangqianfun@163.com");
        //发送邮件的标题
        helper.setSubject("留言成功");
        helper.setText(buildContent(), true);


        String alarmIconName = "success-alarm.png";
        ClassPathResource img = new ClassPathResource("static/"+alarmIconName);
        if (Objects.nonNull(img)) {
            helper.addInline("icon-alarm", img);
        }
        javaMailSender.send(message);
    }

    private static String buildContent() throws IOException {

        //加载邮件html模板
        String fileName = "pod-scale-alarm.html";
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("static/" + fileName);
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        try {
            while ((line = fileReader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
            inputStream.close();
            fileReader.close();
        }


        String contentText = "您已经留言成功,请及时关注管理员回复.<br> <a href='https://www.baidu.com/'>点击查看</a>";
        //下面空格内容五个参数
        String header = "";
        StringBuilder linesBuffer = new StringBuilder();


        //绿色
        String emailHeadColor = "#10fa81";
        String date = DateFormatUtils.format(new Date(), "yyyy/MM/dd HH:mm:ss");
        //填充html模板中的五个参数
        String htmlText = MessageFormat.format(buffer.toString(), emailHeadColor, contentText, date, header, linesBuffer.toString());

        //改变表格样式
        htmlText = htmlText.replaceAll("<td>", "<td style=\"padding:6px 10px; line-height: 150%;\">");
        htmlText = htmlText.replaceAll("<tr>", "<tr style=\"border-bottom: 1px solid #eee; color:#666;\">");
        return htmlText;
    }


}