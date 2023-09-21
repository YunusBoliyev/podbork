package com.geoTwo.project_name.annotation.validator;

import com.geoTwo.project_name.annotation.HasRegion;
import com.geoTwo.project_name.repository.RegionRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class HasRegionValidator implements ConstraintValidator<HasRegion, Long> {

    private final RegionRepository regionRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext constraintValidatorContext) {
        if (value != null) {
            return regionRepository.findByIdAndDeletedFalse(value).isPresent();
        }
        return false;
    }
}
