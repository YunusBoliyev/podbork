package com.geoTwo.project_name.service;

import com.geoTwo.project_name.payload.ApiResponse;
import com.geoTwo.project_name.payload.SendEmailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EmailSendServiceImpl {

    private final EmailService emailSenderService;


    public ApiResponse<?> sendEmil(SendEmailDto dto) {
        emailSenderService.sendEmail(dto);
        return ApiResponse.successResponse("Send  Massage");
    }
}
