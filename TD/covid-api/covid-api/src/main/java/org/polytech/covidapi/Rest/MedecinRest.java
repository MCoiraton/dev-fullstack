package org.polytech.covidapi.Rest;
import java.util.List;

import org.polytech.covidapi.Repository.MedecinRepository;
import org.polytech.covidapi.Services.MedecinService;
import org.polytech.covidapi.Table.Medecin;
import org.polytech.covidapi.Table.Centre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MedecinRest {
    @Autowired
    private MedecinService medecinService;

    @GetMapping(path="/medecins")
    public List<Medecin> getAll(){
        return medecinService.getMedecins();
    }
    @GetMapping(path = "/centerMedecins")
    public List<Medecin> getByCentre(Centre centerId){
        return medecinService.getByCentre(centerId);
    }    
}
