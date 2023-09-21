package com.geoTwo.project_name.service;

import com.geoTwo.project_name.entity.Role;
import com.geoTwo.project_name.entity.User;
import com.geoTwo.project_name.entity.enums.RoleName;
import com.geoTwo.project_name.entity.enums.TypeOfUser;
import com.geoTwo.project_name.payload.ApiResponse;
import com.geoTwo.project_name.payload.UserCreatDto;
import com.geoTwo.project_name.payload.UserDto;
import com.geoTwo.project_name.payload.UserUpdateDto;
import com.geoTwo.project_name.repository.RoleRepository;
import com.geoTwo.project_name.repository.UserRepository;
import com.geoTwo.project_name.utill.MapperDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final MapperDto mapperDto;


    public ApiResponse<?> creatUser(UserCreatDto userCreatDto) {

//        Role employeeRole = roleRepo.save(new Role(RoleName.EMPLOYEE.name()));
//        Set<Role> roles = new HashSet<>();
//        roles.add(employeeRole);
        Optional<Role> roleRepoById = roleRepo.findById(2L);
        if (!roleRepoById.isPresent()) {
            return ApiResponse.errorResponse("Role not Found");
        }
        if (userRepo.existsByPhoneNumber(userCreatDto.getPhoneNumber())) {
            return ApiResponse.errorResponse("The user at this number already exists");
        }
        Role role = roleRepoById.get();
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        User users = new User();
        users.setUsername(userCreatDto.getName());
        users.setAccommodation(userCreatDto.getAccommodation());
        users.setPhoneNumber(userCreatDto.getPhoneNumber());
        users.setEmail(userCreatDto.getEmail());
        users.setPassword(passwordEncoder.encode(userCreatDto.getPassword()));
        users.setRoles(roles);
        users.setTypeOfUser(TypeOfUser.EMPLOYEE.name());
        userRepo.save(users);
        return ApiResponse.successResponse("User added");
    }


    public ApiResponse<?> update(UserUpdateDto updateDto, Long id) {
        Optional<User> optionalUsers = userRepo.findById(id);
        if (!optionalUsers.isPresent()) {
            return ApiResponse.errorResponse("User not found!");
        }

        if (userRepo.existsByPhoneNumber(updateDto.getPhoneNumber())) {
            return ApiResponse.errorResponse("This phone number already exists");
        }

//        {Optional<Role> optionalRole = roleRepo.findById(updateDto.getRoleId());
//        if (!optionalRole.isPresent()) {
//            return ApiResponse.errorResponse("Role not found!");
//        }
//        Role userrole = roleRepo.save(optionalRole.get());
//        Set<Role> roles = new HashSet<>();
//        roles.add(userrole);}
        User users = optionalUsers.get();
        users.setUsername(updateDto.getName());
        users.setAccommodation(updateDto.getAccommodation());
        users.setPhoneNumber(updateDto.getPhoneNumber());
        users.setEmail(updateDto.getEmail());
        userRepo.save(users);
        return ApiResponse.successResponse("User updated");
    }


    public ApiResponse<?> deleteUser(Long id) {
        try {
            userRepo.deleteById(id);
        } catch (Exception e) {
            return ApiResponse.errorResponse("User not deleted");
        }
        return ApiResponse.successResponse("User Deleted ");
    }


    public ApiResponse<?> getByIdUser(Long id) {
        Optional<User> optionalUser = userRepo.findById(id);
        if (!optionalUser.isPresent()) {
            return ApiResponse.errorResponse("User not found");
        }
        return ApiResponse.successResponse(convertToUserDto(optionalUser.get()));
    }

    public ApiResponse<?> getAllUser() {
        List<UserDto> all = userRepo.findAll().stream()
                .map(this::convertToUserDto)
                .collect(Collectors.toList());
        return ApiResponse.successResponse(all);
    }

    public UserDto convertToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getUsername());
        userDto.setAccommodation(user.getAccommodation());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setEmail(user.getEmail());
        userDto.setTypeOfUser(user.getTypeOfUser());

        // rolesId ni olish uchun logika
        Set<Role> roles = user.getRoles();
        if (!roles.isEmpty()) {
            // Barcha rol idlarini `rolesId` ga qo'shish
            List<Long> roleIds = roles.stream()
                    .map(Role::getId)
                    .collect(Collectors.toList());
            userDto.setRolesId(roleIds);
        }

        return userDto;
    }

//    public List<UserDto> getAllUserDtos() {
//        List<User> users = userRepo.findAll();
//        List<UserDto> userDtos = new ArrayList<>();
//        for (User user : users) {
//            UserDto userDto = new UserDto();
//            userDto.setName(user.getUsername());
//            userDto.setAccommodation(user.getAccommodation());
//            userDto.setPhoneNumber(user.getPhoneNumber());
//            userDto.setEmail(user.getEmail());
//
//            // rolesId ni olish uchun logika
//            Set<Role> roles = user.getRoles();
//            if (!roles.isEmpty()) {
//                // Barcha rol idlarini `rolesId` ga qo'shish
//                List<Long> roleIds = roles.stream()
//                        .map(Role::getId)
//                        .collect(Collectors.toList());
//                userDto.setRolesId(roleIds);
//            }
//
//            userDtos.add(userDto);
//        }
//        return userDtos;
//    }

}
