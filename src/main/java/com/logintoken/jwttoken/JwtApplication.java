package com.logintoken.jwttoken;

import com.logintoken.jwttoken.Repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.logintoken.jwttoken.Entity.Role;
import com.logintoken.jwttoken.Config.AppConstant;
import java.util.List;

@SpringBootApplication
public class JwtApplication implements CommandLineRunner {
	@Autowired
	private RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		try {
			Role role = new Role();
			role.setId(AppConstant.ADMIN_USER);
			role.setName("ADMIN_USER");
			Role role1 = new Role();
			role1.setId(AppConstant.NORMAL_USER);
			role1.setName("NORMAL_USER");
			List<Role> roles = List.of(role, role1);
			this.roleRepo.saveAll(roles);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
