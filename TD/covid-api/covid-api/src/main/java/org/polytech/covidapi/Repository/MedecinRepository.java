package org.polytech.covidapi.Repository;
import java.util.List;

import org.polytech.covidapi.Table.Medecin;
import org.polytech.covidapi.Table.Centre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedecinRepository extends JpaRepository <Medecin, Integer>{
    List<Medecin> findByCentre (Centre centre);
}