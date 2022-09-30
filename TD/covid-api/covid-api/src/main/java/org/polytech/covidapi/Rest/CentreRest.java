package org.polytech.covidapi.Rest;

import java.util.List;

import org.polytech.covidapi.Repository.CentreRepository;
import org.polytech.covidapi.Services.CentreService;
import org.polytech.covidapi.Table.Centre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CentreRest {
    
    @Autowired 
    private CentreService centreService;

    @GetMapping(path = "/centres")
    public List<Centre> getAll(){
        return centreService.getCentres();
    }
    @GetMapping(path = "/ville")
    public List<Centre> getByVille(String ville){
        return centreService.getByVille(ville);
    }

}
