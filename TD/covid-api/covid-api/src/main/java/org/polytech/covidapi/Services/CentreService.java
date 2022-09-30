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
        List<Centre> centres = new ArrayList<>();
        centreRepository.findAll().forEach(centres::add);
        return centres;
    }
}
