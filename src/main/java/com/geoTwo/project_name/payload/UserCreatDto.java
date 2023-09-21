package com.geoTwo.project_name.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreatDto {

    private Long id;

    private String name;

    private String accommodation;

    @Column(nullable = false)
    private String phoneNumber;

    private String email;

    private String password;



}
