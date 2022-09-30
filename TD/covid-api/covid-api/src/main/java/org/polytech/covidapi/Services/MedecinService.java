package org.polytech.covidapi.Services;
import java.util.ArrayList;
import java.util.List;

import org.polytech.covidapi.Repository.MedecinRepository;
import org.polytech.covidapi.Table.Centre;
import org.polytech.covidapi.Table.Medecin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MedecinService {
    @Autowired
    private MedecinRepository medecinRepository;

    public Medecin getMedecin(int id){
        return medecinRepository.getReferenceById(id);
    }

    public List<Medecin> getMedecins(){
        List<Medecin> medecins = new ArrayList<>();
        medecinRepository.findAll().forEach(medecins::add);
        return medecins;
    }

    public List<Medecin> getByCentre(Centre centre){
        List<Medecin>medecins = new ArrayList<>();
        medecinRepository.findByCentre(centre).forEach(medecins::add);
        return medecins;
    }
}   
