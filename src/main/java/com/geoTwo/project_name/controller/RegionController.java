package com.geoTwo.project_name.controller;

import com.geoTwo.project_name.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/region")
@RequiredArgsConstructor
public class RegionController {

    private final RegionService regionService;

    @GetMapping("/select")
    public HttpEntity<?> getRegionForSelect() {
        return regionService.getRegionForSelect();
    }
}
