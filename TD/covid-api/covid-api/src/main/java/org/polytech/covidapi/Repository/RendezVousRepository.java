package org.polytech.covidapi.Repository;
import java.util.List;

import org.polytech.covidapi.Table.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RendezVousRepository extends JpaRepository <RendezVous, Integer>{
    @Query("SELECT R FROM RendezVous R WHERE R.firstName = :name OR R.lastName = :name")
    List<RendezVous> findByName (@Param("name") String name);
}