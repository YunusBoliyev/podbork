package com.geoTwo.project_name.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserUpdateDto {
    private String name;
    private String accommodation;
    private String phoneNumber;
    private String email;
}
