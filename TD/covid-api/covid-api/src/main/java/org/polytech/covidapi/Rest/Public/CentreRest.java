package org.polytech.covidapi.Rest.Public;

import java.util.List;

import org.polytech.covidapi.Services.CentreService;
import org.polytech.covidapi.Table.Centre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CentreRest {
    
    @Autowired 
    private CentreService centreService;

    @GetMapping(path = "/centres")
    public List<Centre> getAll(){
        return centreService.getCentres();
    }
    @GetMapping(path = "/ville/{nomVille}")
    public List<Centre> getByVille(
        @PathVariable("nomVille") String ville){
        return centreService.getByVille(ville);
    }

}
