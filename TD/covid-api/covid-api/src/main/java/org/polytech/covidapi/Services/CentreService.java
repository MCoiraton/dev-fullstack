package org.polytech.covidapi.Services;

import java.util.ArrayList;
import java.util.List;

import org.polytech.covidapi.Repository.CentreRepository;
import org.polytech.covidapi.Table.Centre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CentreService {
    @Autowired
    private CentreRepository centreRepository;

    public Centre getCentre(int id){
        return centreRepository.getReferenceById(id);
    }

    public List<Centre> getCentres(){
        return centreRepository.findAll();
    }

    public List<Centre>getByVille(String ville){
        List<Centre> centres=new ArrayList<>();
        centreRepository.findByVille(ville).forEach(centres::add);;
        return centres;
    }
}
