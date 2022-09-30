package org.polytech.covidapi.Rest;
import java.util.List;

import org.polytech.covidapi.Repository.AdminRepository;
import org.polytech.covidapi.Services.AdminService;
import org.polytech.covidapi.Table.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminRest {
    @Autowired
    private AdminService adminService;

    @GetMapping(path="/admins")
    public List<Admin> getAll(){
        return adminService.getAdmins();
    }
    @GetMapping(path = "/centerAdmins")
    public List<Admin> getByCentre(Integer centerId){
        return adminService.getByCenter(centerId);
    }
}
