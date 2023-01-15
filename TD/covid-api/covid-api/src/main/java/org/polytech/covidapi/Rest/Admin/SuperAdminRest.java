package org.polytech.covidapi.Rest.Admin;

import java.util.List;

import org.polytech.covidapi.Repository.CentreRepository;
import org.polytech.covidapi.Repository.LoginRepository;
import org.polytech.covidapi.Services.AdminService;
import org.polytech.covidapi.Services.CentreService;
import org.polytech.covidapi.Services.UserService;
import org.polytech.covidapi.Table.Centre;
import org.polytech.covidapi.Table.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@CrossOrigin
@RequestMapping(path = "superadmin")
public class SuperAdminRest {
    
    private final CentreService centreService;
    private final AdminService adminService;
    private final UserService userService;
    private final CentreRepository repository;
    private final LoginRepository user_repo;
    private static Logger log = LoggerFactory.getLogger(CentreService.class);
    private final PasswordEncoder passwordEncoder;

    public SuperAdminRest(CentreService centreService, AdminService adminService, UserService userService ,
    CentreRepository repository, PasswordEncoder passwordEncoder, LoginRepository user_repo){
        this.centreService = centreService;
        this.adminService = adminService;
        this.repository = repository;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.user_repo = user_repo;
    }

    //PARTIE CENTRES
    @GetMapping(path = "/centres/{id}")
    public Centre getCentre(@PathVariable("id") int id){
        return centreService.getById(id);
    }

    @DeleteMapping(path = "/centres/{id}")
        public ResponseEntity<Centre> deleteCentre(@PathVariable("id") int id){
            log.info("Test", id);
            Centre centre = centreService.getById(id);
            repository.delete(centre);
            return ResponseEntity.ok(centre);
        }


    //PARTIE ADMIN 
    @GetMapping(path = "/admin/{id}")
    public Users getAdmin(@PathVariable("id") int id) {
        return userService.getById(id);
    }

    @PostMapping(path = "/newadmin")
    public void createAdmin(@RequestBody Users user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addUsers(user);
    }

    @DeleteMapping(path = "/admin/{id}")
    public ResponseEntity<Users> deleteAdmin(@PathVariable("id") int id){
        Users user = userService.getById(id);
        user_repo.delete(user);
        return ResponseEntity.ok(user);

        
    }


}



    

