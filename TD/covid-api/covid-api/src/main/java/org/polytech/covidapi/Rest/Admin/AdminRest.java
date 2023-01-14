package org.polytech.covidapi.Rest.Admin;
import java.util.List;
import java.util.Optional;

import org.polytech.covidapi.Repository.AdminRepository;
import org.polytech.covidapi.Repository.RendezVousRepository;
import org.polytech.covidapi.Services.AdminService;
import org.polytech.covidapi.Services.RendezVousService;
import org.polytech.covidapi.Table.Admin;
import org.polytech.covidapi.Table.Centre;
import org.polytech.covidapi.Table.RendezVous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminRest {
    @Autowired
    private AdminService adminService;
    private final RendezVousService rendezVousService;
    private final RendezVousRepository repository;

    public AdminRest(RendezVousService rendezVousService, RendezVousRepository repository){
        this.rendezVousService = rendezVousService;
        this.repository = repository;
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

   

}
