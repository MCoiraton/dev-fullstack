package org.polytech.covidapi.Table;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="RendezVous")
public class RendezVous {
    @Id
    private Integer id;
    private String mail;
    private Integer tel;
    private String firstName;
    private String lastName;
    private Date appointmentDate;
    
    @ManyToOne
    @JoinColumn(name="centre_id")
    private Centre centre;

}
