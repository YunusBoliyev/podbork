package com.geoTwo.project_name.repository;

import com.geoTwo.project_name.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role getRoleByName(String name);

    Optional<Role> findByNameAndDeletedFalse(String name);
}
