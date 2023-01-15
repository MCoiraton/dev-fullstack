package org.polytech.covidapi.Rest.Public;

import java.util.List;
import java.util.Optional;

import org.polytech.covidapi.Repository.RendezVousRepository;
import org.polytech.covidapi.Services.RendezVousService;
import org.polytech.covidapi.Table.RendezVous;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(path = "/medecin")
public class MedecinRest {

    private final RendezVousService rendezVousService;
    private final RendezVousRepository repository;

    public MedecinRest(RendezVousService rendezVousService, RendezVousRepository repository){
        this.rendezVousService = rendezVousService;
        this.repository = repository;
    }

    @GetMapping(path = "/patient/{first_name}")
    public List<RendezVous> getByName(
        @PathVariable("first_name") String first_name){
            List<RendezVous> rdv = rendezVousService.getByName(first_name);
            return rdv;
        }

    
    @PutMapping(path = "/appointment/{id}")
    public ResponseEntity<RendezVous> updateRendezVous(
        @PathVariable("id") int id,
        @RequestBody RendezVous rdv){
            Optional<RendezVous> currentRendezVous = repository.findById(id);
            rdv = currentRendezVous.get();
            rdv.setVaccinated(true);
            final RendezVous updatedRendezVous = repository.save(rdv);
            return ResponseEntity.ok(updatedRendezVous);
        }
            
    }

    

