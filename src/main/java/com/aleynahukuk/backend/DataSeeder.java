package com.aleynahukuk.backend;

import com.aleynahukuk.backend.entity.Admin;
import com.aleynahukuk.backend.repository.AdminRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private AdminRepository adminRepository;

    public DataSeeder(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (adminRepository.count() == 0) {
            Admin newAdmin = new Admin();
            newAdmin.setUsername("admin");
            newAdmin.setPassword("1234");
            adminRepository.save(newAdmin);
            System.out.println("VARSAYILAN ADMIN OLUŞTURULDU (USERNAME: admin, PASSWORD: 1234)");
        }
    }
}
