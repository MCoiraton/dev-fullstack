package org.polytech.covidapi;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Medecin")
public class Medecin {
    @Id
    private Integer id;
    private String pwd;
    private String nom;
    private String prenom;
    private Centre centre;
}
