package org.polytech.covidapi.Services;
import java.util.ArrayList;
import java.util.List;

import org.polytech.covidapi.Repository.RendezVousRepository;
import org.polytech.covidapi.Table.Centre;
import org.polytech.covidapi.Table.RendezVous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RendezVousService {
    @Autowired 
    private RendezVousRepository rendezVousRepository;

    public RendezVous getRendezVous(int id){
        return rendezVousRepository.getReferenceById(id);
    }

    public List<RendezVous> getRendezVous(){
        return rendezVousRepository.findAll();
    }

    /*public List<RendezVous> getByName(String name){
        List<RendezVous> rendezVous=new ArrayList<>();
        rendezVousRepository.findByName(name).forEach(rendezVous::add);
        return rendezVous;
    }*/

    public List<RendezVous> getByCentre(Centre centre){
        List<RendezVous>rendezVous = new ArrayList<>();
        rendezVousRepository.findByCentre(centre).forEach(rendezVous::add);
        return rendezVous;
    }

    
    public List<RendezVous> getByName(String first_name){
        return rendezVousRepository.findByFirstName(first_name);
        
    }

    public List<RendezVous> getByEmail(String email){
        return rendezVousRepository.findByMail(email);
        
    }

    public RendezVous getById(int id) {
        return rendezVousRepository.findById(id).get();
    }

    public void delete(RendezVous rendezvous){
        rendezVousRepository.delete(rendezvous);
    }
}
