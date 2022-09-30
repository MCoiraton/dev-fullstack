package org.polytech.covidapi.Table;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Centre")
public class Centre {
    @Id
    private Integer centre_id;
    private String ville;
    private String adresse;
    
}
