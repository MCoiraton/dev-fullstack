package org.polytech.covidapi.Rest.Admin;

import org.polytech.covidapi.Repository.RendezVousRepository;
import org.polytech.covidapi.Services.AdminService;
import org.polytech.covidapi.Services.RendezVousService;
import org.polytech.covidapi.Services.UserService;
import org.polytech.covidapi.Table.RendezVous;
import org.polytech.covidapi.Table.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminRest {
    @Autowired
    private AdminService adminService;
    private final RendezVousService rendezVousService;
    private final RendezVousRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public AdminRest(RendezVousService rendezVousService, RendezVousRepository repository, PasswordEncoder passwordEncoder, UserService userService){
        this.rendezVousService = rendezVousService;
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    //PARTIE RESERVATION

    @GetMapping(path = "/appointment/{id}")
    public RendezVous getRendezVous(@PathVariable("id") int id){
        return rendezVousService.getById(id);
      
    }

   @DeleteMapping(path = "/appointment/{id}")
   public ResponseEntity<RendezVous> deleteRendezVous(@PathVariable("id") int id){
        RendezVous rdv = rendezVousService.getById(id);
        repository.delete(rdv);
        return ResponseEntity.ok(rdv);
   } 

   //PARTIE MEDECIN

   @PostMapping("/medecin")
   public void createMedecin(@RequestBody Users user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addUsers(user);
   }

   @GetMapping("/medecin/{id}")
   public Users getMedecin(@PathVariable("id") int id){
    return userService.getMedecin(id);
   }

}
