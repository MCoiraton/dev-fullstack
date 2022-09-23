package org.polytech.covidapi;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedecinRepository extends JpaRepository <Medecin, Integer>{
    List<Medecin> findByCenter (Integer centerId);
}