package com.geoTwo.project_name.controller;

import com.geoTwo.project_name.annotation.HasRegion;
import com.geoTwo.project_name.service.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/district")
@RequiredArgsConstructor
public class DistrictController {

    private final DistrictService districtService;

    @GetMapping("/select")
    public HttpEntity<?> getRegionForSelect(@RequestParam(name = "region_id", required = false) @HasRegion Long regionId) {
        return districtService.getRegionForSelect(regionId);
    }
}
