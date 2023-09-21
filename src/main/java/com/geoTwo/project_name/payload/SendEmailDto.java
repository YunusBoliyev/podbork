package com.geoTwo.project_name.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SendEmailDto {
    @NotNull
    @Email
    private String userEmail;
    private String body;
    private String subject;

}
