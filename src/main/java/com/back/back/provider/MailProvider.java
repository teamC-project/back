package com.back.back.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.Message.RecipientType;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class MailProvider {

    @Value("${spring.mail.username}")
    private String from;
    private final JavaMailSender javaMailSender;

<<<<<<< HEAD
=======

>>>>>>> 9c6ee28a18fb7581c09fe346a30cde228212daed
    public void mailAuthSend (String to, String authNumber) throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        mimeMessage.setFrom(from);
        mimeMessage.setRecipient(RecipientType.TO, new InternetAddress(to));
<<<<<<< HEAD
        mimeMessage.setSubject("estate 인증 번호");
=======
        mimeMessage.setSubject("헤어어드바 인증 번호");
>>>>>>> 9c6ee28a18fb7581c09fe346a30cde228212daed
        mimeMessage.setText(getText(authNumber), "utf-8", "html");
        javaMailSender.send(mimeMessage);

    }

    private String getText (String authNumber) {
        String text = 
<<<<<<< HEAD
            "<h2 style='text-align: center;'>estate 인증 번호</h2>" +
=======
            "<h2 style='text-align: center;'>헤어어드바 인증 번호</h2>" +
>>>>>>> 9c6ee28a18fb7581c09fe346a30cde228212daed
            "<p>요청하신 email 인증 번호는 <strong style='color: red;'>" + 
            authNumber +
            "</strong>입니다.</p>";
        return text;
    }

    
}