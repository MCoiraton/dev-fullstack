package org.polytech.covidapi.Rest;
import java.util.List;

import org.polytech.covidapi.Repository.RendezVousRepository;
import org.polytech.covidapi.Services.RendezVousService;
import org.polytech.covidapi.Table.RendezVous;
import org.polytech.covidapi.Table.Centre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RendezVousRest {
    @Autowired
    private RendezVousService rendezVousService;

    @GetMapping(path="/medecins")
    public List<RendezVous> getAll(){
        return rendezVousService.getRendezVous();
    }
    @GetMapping(path = "/centerMedecins")
    public List<Medecin> getByCentre(Centre centerId){
        return medecinService.getByCentre(centerId);
    }    
}
