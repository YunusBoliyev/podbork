package com.geoTwo.project_name.utill;


import com.geoTwo.project_name.entity.District;
import com.geoTwo.project_name.entity.Region;
import com.geoTwo.project_name.payload.admin.request.DistrictDto;
import com.geoTwo.project_name.payload.admin.request.RegionDto;
import com.geoTwo.project_name.repository.RegionRepository;
import com.geoTwo.project_name.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MapperDto {

    private final RegionRepository regionRepository;

    public Region makeRegion(RegionDto regionDto) {
        if (regionDto != null) {
            return makeOrUpdateRegion(regionDto, new Region());
        }
        return null;
    }

    public Region updateRegion(RegionDto regionDto, Region region) {
        if (regionDto != null) {
            return makeOrUpdateRegion(regionDto, region);
        }
        return null;
    }

    private Region makeOrUpdateRegion(RegionDto regionDto, Region region) {
        region.setName(regionDto.getName());
        return region;
    }

    public District makeDistrict(DistrictDto districtDto) {
        if (districtDto != null) {
            return makeOrUpdateDistrict(districtDto, new District());
        }
        return null;
    }

    public District updateDistrict(DistrictDto districtDto, District district) {
        if (districtDto != null) {
            return makeOrUpdateDistrict(districtDto, district);
        }
        return null;
    }

    private District makeOrUpdateDistrict(DistrictDto districtDto, District district) {
        district.setName(districtDto.getName());
        Optional<Region> optionalRegion = regionRepository.findByIdAndDeletedFalse(districtDto.getRegionId());
        optionalRegion.ifPresent(district::setRegion);
        return district;
    }
}
