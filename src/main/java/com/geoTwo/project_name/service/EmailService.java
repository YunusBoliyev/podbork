package com.geoTwo.project_name.service;

import com.geoTwo.project_name.payload.SendEmailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;
    public void sendEmail(SendEmailDto dto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(dto.getUserEmail());
        message.setSubject(dto.getSubject());
        message.setText(dto.getBody());
        javaMailSender.send(message);
    }
}


