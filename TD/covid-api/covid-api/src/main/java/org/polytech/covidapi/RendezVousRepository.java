package org.polytech.covidapi;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RendezVousRepository extends JpaRepository <RendezVous, Integer>{
    List<RendezVous> findByName (String name);
}