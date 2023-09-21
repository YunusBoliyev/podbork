package com.geoTwo.project_name.payload.admin.response;

import java.sql.Timestamp;

public interface RegionProjection {

    Long getId();

    Timestamp getCreatedAt();

    String getName();
}
