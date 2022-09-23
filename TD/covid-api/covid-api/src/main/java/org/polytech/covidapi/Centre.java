package org.polytech.covidapi;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Centre")
public class Centre {
    @Id
    private Integer id;
    private String ville;
    private String adresse;
    
}
