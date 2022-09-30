package org.polytech.covidapi.Table;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Centre")
public class Centre {
    @Id
    private Integer centre_id;
    private String nom;
    private String adresse;
    private String ville;   
}
