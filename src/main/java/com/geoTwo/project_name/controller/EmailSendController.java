package com.geoTwo.project_name.controller;


import com.geoTwo.project_name.payload.ApiResponse;
import com.geoTwo.project_name.payload.SendEmailDto;
import com.geoTwo.project_name.service.EmailSendServiceImpl;
import com.geoTwo.project_name.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailSendController {

    private final EmailSendServiceImpl service;


    @PostMapping("sendEmail")
    public HttpEntity<?> sendEmailAttachment(@RequestBody SendEmailDto dto) {
        ApiResponse<?> response = service.sendEmil(dto );
        return ResponseEntity.status(response.isSuccess() ? 201 : 409).body(response);
    }

}
