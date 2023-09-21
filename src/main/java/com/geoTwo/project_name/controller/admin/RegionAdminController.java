package com.geoTwo.project_name.controller.admin;

import com.geoTwo.project_name.payload.admin.request.RegionDto;
import com.geoTwo.project_name.service.RegionService;
import com.geoTwo.project_name.utill.AppConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin/region")
@RequiredArgsConstructor
public class RegionAdminController {

    private final RegionService regionService;

    @PreAuthorize("hasAnyAuthority('SUPER_ADMIN')")
    @PostMapping("/add")
    public HttpEntity<?> addNewRegion(@RequestBody @Valid RegionDto regionDto) {
        return regionService.addRegion(regionDto);
    }

    @PreAuthorize("hasAnyAuthority('SUPER_ADMIN')")
    @PutMapping("/edit/{id}")
    public HttpEntity<?> editRegion(@PathVariable("id") Long regionId,
                                    @RequestBody @Valid RegionDto regionDto) {
        return regionService.editRegion(regionId, regionDto);
    }

    @PreAuthorize("hasAnyAuthority('SUPER_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteRegion(@PathVariable("id") Long regionId) {
        return regionService.deleteRegion(regionId);
    }

    @PreAuthorize("hasAnyAuthority('SUPER_ADMIN')")
    @GetMapping()
    public HttpEntity<?> getRegionPageable(@RequestParam(name = "search", required = false) String search,
                                           @RequestParam(name = "from_to", required = false) List<String> fromTo,
                                           @RequestParam(name = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
                                           @RequestParam(name = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
        return regionService.getPageableRegion(search, fromTo, page, size);
    }
}
