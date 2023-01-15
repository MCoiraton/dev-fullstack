package org.polytech.covidapi.Repository;
import java.util.List;
import java.util.Optional;

import org.polytech.covidapi.Table.Centre;
import org.polytech.covidapi.Table.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RendezVousRepository extends JpaRepository <RendezVous, Integer>{
    //@Query("SELECT R FROM RendezVous R WHERE R.firstName = :name OR R.lastName = :name")
    //List<RendezVous> findByName (@Param("name") String name);
    List<RendezVous> findByCentre (Centre centre);
    List<RendezVous> findAllByCentre_id (int centre_id);
    List<RendezVous> findByMail (@Param("mail") String mail);
    List<RendezVous> findByFirstName (@Param("first_name") String first_name);
    void delete(RendezVous rendezVous);
    Object save(Optional<RendezVous> currentRendezVous);
}