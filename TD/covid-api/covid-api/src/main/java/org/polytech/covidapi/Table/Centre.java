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

    public Integer getCentreId(){
    return centre_id;
    }

    public String getNom(){
        return nom;
    }

    public void setCentre_id(Integer centre_id) {
        this.centre_id = centre_id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse(){
        return adresse;
    }

    public String getVille(){
        return ville;
    }
    
}
