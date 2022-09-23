package org.polytech.covidapi;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin {
    @Id
    Integer id;
    Centre centre;
    
}
