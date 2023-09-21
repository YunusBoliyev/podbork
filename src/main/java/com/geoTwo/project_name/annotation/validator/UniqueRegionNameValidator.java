package com.geoTwo.project_name.annotation.validator;

import com.geoTwo.project_name.annotation.UniqueRegionName;
import com.geoTwo.project_name.repository.RegionRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniqueRegionNameValidator implements ConstraintValidator<UniqueRegionName, String> {

    private final RegionRepository regionRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value != null) {
            return regionRepository.getCountByNameNative(value) == 0;
        }
        return false;
    }
}
