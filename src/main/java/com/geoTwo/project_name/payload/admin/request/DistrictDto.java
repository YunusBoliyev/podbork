package com.geoTwo.project_name.payload.admin.request;

import com.geoTwo.project_name.annotation.HasRegion;
import com.geoTwo.project_name.annotation.UniqueDistrictName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDto {

    @NotNull
    @UniqueDistrictName
    private String name;

    @NotNull
    @HasRegion
    private Long regionId;
}
