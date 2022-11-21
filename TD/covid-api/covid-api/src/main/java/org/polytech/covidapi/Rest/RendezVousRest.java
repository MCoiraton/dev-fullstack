package org.polytech.covidapi.Rest;
import java.util.List;

import org.polytech.covidapi.Repository.RendezVousRepository;
import org.polytech.covidapi.Services.RendezVousService;
import org.polytech.covidapi.Table.RendezVous;
import org.polytech.covidapi.Table.Centre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class RendezVousRest {
    @Autowired
    private RendezVousService rendezVousService;

    @GetMapping(path="/rdvs")
    public List<RendezVous> getAll(){
        return rendezVousService.getRendezVous();
    }
    @GetMapping(path="/rdv")
    public List<RendezVous> getByName(String name){
        return rendezVousService.getByName(name);
    }
    @GetMapping(path = "/centerRdv")
    public List<RendezVous> getByCentre(Centre centerId){
        return rendezVousService.getByCentre(centerId);
    }    
}
