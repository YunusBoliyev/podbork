package com.geoTwo.project_name.payload.admin.request;

import com.geoTwo.project_name.annotation.UniqueRegionName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegionDto {

    @NotNull
    @UniqueRegionName
    private String name;
}
