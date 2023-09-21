package com.geoTwo.project_name.component;

import com.geoTwo.project_name.entity.Role;
import com.geoTwo.project_name.entity.User;
import com.geoTwo.project_name.entity.enums.RoleName;
import com.geoTwo.project_name.entity.enums.TypeOfUser;
import com.geoTwo.project_name.repository.RoleRepository;
import com.geoTwo.project_name.repository.UserRepository;
import com.geoTwo.project_name.secret.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepo;

    private final RoleRepository roleRepo;

    private final JwtProvider provider;

    @Value("${spring.sql.init.mode}")
    private String mode;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void run(String... args) throws Exception {

        if (mode.equals("always")) {
            Role superAdminRole = roleRepo.save(new Role(RoleName.SUPER_ADMIN.name()));
            Role employeeRole = roleRepo.save(new Role(RoleName.EMPLOYEE.name()));

            Set<Role> admin = new HashSet<>();
            Set<Role> employee = new HashSet<>();
            admin.add(superAdminRole);
            employee.add(employeeRole);
            //User superAdmin = new User("admin", passwordEncoder.encode("123"), roles, TypeOfUser.SUPER_ADMIN.name());
            User superAdmin= new User("Firuz","Milliy bog'","+998932101600","erkenovferuz2000@gmail.com",passwordEncoder.encode("feruz.2000"),admin,TypeOfUser.SUPER_ADMIN.name());
            User employeeUser= new User("Dilaziz","mars","+001601239899","podborkbk@gmail.com",passwordEncoder.encode("mars"),employee,TypeOfUser.EMPLOYEE.name());
            userRepo.save(superAdmin);
            userRepo.save(employeeUser);
        }
    }
}
