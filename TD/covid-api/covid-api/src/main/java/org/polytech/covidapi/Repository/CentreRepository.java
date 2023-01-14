package org.polytech.covidapi.Repository;

import java.util.List;

import org.polytech.covidapi.Table.Centre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentreRepository extends JpaRepository <Centre, Integer>{
    List<Centre> findByVille (String ville);
    Centre getById(int id);
    void delete(Centre centre);
}