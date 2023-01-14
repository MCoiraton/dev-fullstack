package org.polytech.covidapi.Rest.Admin;

import java.util.List;

import org.polytech.covidapi.Repository.CentreRepository;
import org.polytech.covidapi.Services.AdminService;
import org.polytech.covidapi.Services.CentreService;
import org.polytech.covidapi.Table.Centre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "superadmin")
public class SuperAdminRest {
    
    private final CentreService centreService;
    private final AdminService adminService;
    private final CentreRepository repository;
    private static Logger log = LoggerFactory.getLogger(CentreService.class);

    public SuperAdminRest(CentreService centreService, AdminService adminService, CentreRepository repository){
        this.centreService = centreService;
        this.adminService = adminService;
        this.repository = repository;
    }

    //PARTIE CENTRES
    @GetMapping(path = "/centres")
    public List<Centre> getAll(){
        return centreService.getCentres();
    }

    @DeleteMapping(path = "/centres/{id}")
        public ResponseEntity<Centre> deleteCentre(@PathVariable("id") int id){
            log.info("Test", id);
            Centre centre = centreService.getById(id);
            repository.delete(centre);
            return ResponseEntity.ok(centre);
        }
}



    

