package org.polytech.covidapi.Table;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Medecin")
public class Medecin {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name="centre_id")
    private Centre centre;

    private String pwd;
    private String nom;
    private String prenom;
}
