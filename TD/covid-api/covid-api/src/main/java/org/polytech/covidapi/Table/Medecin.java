package org.polytech.covidapi.Table;

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
    private Integer idCentre;
}
