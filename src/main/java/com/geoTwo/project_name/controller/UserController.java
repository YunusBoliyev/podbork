package com.geoTwo.project_name.controller;

import com.geoTwo.project_name.payload.ApiResponse;
import com.geoTwo.project_name.payload.UserCreatDto;
import com.geoTwo.project_name.payload.UserUpdateDto;
import com.geoTwo.project_name.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("createUser")
    public HttpEntity<?> create(@RequestBody UserCreatDto creatDto) {
        ApiResponse<?> response = userService.creatUser(creatDto);
        return ResponseEntity.status(response.isSuccess()?200:409).body(response);
    }

    @PutMapping("updateUser/{id}")
    public HttpEntity<?> update(@RequestBody UserUpdateDto updateDto, @PathVariable Long id) {
        ApiResponse<?> response =userService.update(updateDto,id);
        return ResponseEntity.status(response.isSuccess()?200:409).body(response);
    }

    @PreAuthorize(value = "hasAnyAuthority('SUPER_ADMIN')")
    @GetMapping("getAllUser")
    public HttpEntity<?> get() {
        ApiResponse<?> response =userService.getAllUser();
        return ResponseEntity.status(response.isSuccess()?200:409).body(response);
    }

    @GetMapping("getByIdUser/{id}")
     public HttpEntity<?> getById(@PathVariable Long id) {
        ApiResponse<?> response=userService.getByIdUser(id);
        return ResponseEntity.status(response.isSuccess()?200:400).body(response);
    }

    @DeleteMapping("deleteByUser/{id}")
    public HttpEntity<?> delete(@PathVariable Long id) {
        ApiResponse<?>response = userService.deleteUser(id);
        return ResponseEntity.status(response.isSuccess()?200:409).body(response);
    }

}
