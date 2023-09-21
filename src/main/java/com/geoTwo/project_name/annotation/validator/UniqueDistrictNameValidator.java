package com.geoTwo.project_name.annotation.validator;

import com.geoTwo.project_name.annotation.UniqueDistrictName;
import com.geoTwo.project_name.repository.DistrictRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@RequiredArgsConstructor
public class UniqueDistrictNameValidator implements ConstraintValidator<UniqueDistrictName, String> {


    private final DistrictRepository districtRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value != null) {
            return districtRepository.getCountByNameNative(value) == 0;
        }
        return false;
    }
}
