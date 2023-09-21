package com.geoTwo.project_name.service;

import com.geoTwo.project_name.repository.RoleRepository;
import com.geoTwo.project_name.repository.UserRepository;
import com.geoTwo.project_name.utill.MapperDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService_1 {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final MapperDto mapperDto;

}
