package com.geoTwo.project_name.controller;

import com.geoTwo.project_name.payload.LoginDto;
import com.geoTwo.project_name.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public HttpEntity<?> login(@RequestBody @Valid LoginDto loginDto){
        return authService.login(loginDto);
    }
}
