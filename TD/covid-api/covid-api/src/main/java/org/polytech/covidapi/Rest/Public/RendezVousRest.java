package org.polytech.covidapi.Rest.Public;
import java.util.List;

import org.polytech.covidapi.Repository.RendezVousRepository;
import org.polytech.covidapi.Services.RendezVousService;
import org.polytech.covidapi.Table.RendezVous;
import org.polytech.covidapi.Table.Centre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("/api")
public class RendezVousRest {
    @Autowired
    private RendezVousService rendezVousService;
    private final RendezVousRepository repository;

    RendezVousRest(RendezVousRepository repository){
        this.repository = repository;
    }
    

    @GetMapping(path ="/rdvs")
    public List<RendezVous> getAll(){
        return rendezVousService.getRendezVous();
    }

    @GetMapping(path = "/rdvs/{mail}")
    public List<RendezVous> getByEmail(
        @PathVariable("mail") String mail){
        return rendezVousService.getByEmail(mail);
    }

    /*@GetMapping(path="/rdv")
    public List<RendezVous> getByName(String name){
        return rendezVousService.getByName(name);
    }*/
    @GetMapping(path = "/centerRdv")
    public List<RendezVous> getByCentre(Centre centerId){
        return rendezVousService.getByCentre(centerId);
    }
    @PostMapping(path = "/appointment")
    RendezVous newRendezVous(@RequestBody RendezVous newRendezVous){
        return repository.save(newRendezVous);
    }
    
}
