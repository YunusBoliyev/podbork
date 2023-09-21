package com.geoTwo.project_name.payload.admin.response;

import java.sql.Timestamp;

public interface DistrictProjection {

    Long getId();

    Timestamp getCreatedAt();

    String getName();

    String getRegionName();
}
