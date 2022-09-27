package org.polytech.covidapi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentreRepository extends JpaRepository <Centre, Integer>{
    List<Centre> findByVille (String ville);
}