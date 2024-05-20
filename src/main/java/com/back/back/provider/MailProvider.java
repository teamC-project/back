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
    private final JwtProvider javaMailSender;
    // 이메일 인증 메일 전송 메서드
    // throws MessagingException: 밑의 메시지 속성을 실행하는데 예외처리를 하기 위함
    public void mailAuthSend (String to, String authNumber) throws MessagingException  {

    // 전송할 메시지 객체 생성
    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    // 메시지 전송자 메일 지정
    mimeMessage.setFrom(from);
    // 메시지 수신자 메일 지정
    mimeMessage.setRecipient(RecipientType.TO, new InternetAddress(to));
    // 메시지 제목 지정
    mimeMessage.setSubject("estate 인증 번호");
    // 메시지 내용 지정
    mimeMessage.setText(getText(authNumber), "utf-8", "html");
    // 메시지 전송
    javaMailSender.send(mimeMessage);

    }

    private String getText(String authNumber) {
        String text = 
        "<h2 style='text-align: center'>estate 인증 번호 </h2>" +
        "<p>요청하신 email 인증 번호는 <strong style='color: red;'>"+ 
        authNumber + 
        "</strong>입니다.</p>";

        return text;
    }

}
