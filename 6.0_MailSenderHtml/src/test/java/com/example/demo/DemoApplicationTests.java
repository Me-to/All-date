package com.example.demo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoApplicationTests {

@Autowired
SendEmailUtil sendEmailUtil;
    @Test
    public void main() {
        try {
            sendEmailUtil.sendMail();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
