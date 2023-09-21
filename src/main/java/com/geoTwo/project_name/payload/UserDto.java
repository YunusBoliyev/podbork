package com.geoTwo.project_name.payload;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserDto {

    private Long id;

    private String name;

    private String accommodation;

    @Column(nullable = false)
    private String phoneNumber;

    private String email;

    private List<Long> rolesId;

    private String typeOfUser;


}
