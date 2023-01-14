package org.polytech.covidapi.Table;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin {
    @Id
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name="centre_id")
    private Centre centre;
    
    public Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCentre(Centre centre) {
        this.centre = centre;
    }

    public Centre getCentre(){
        return centre;
    }

}
