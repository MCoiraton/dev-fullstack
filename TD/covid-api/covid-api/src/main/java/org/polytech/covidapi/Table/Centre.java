package org.polytech.covidapi.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Centre")
public class Centre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String nom;
    private String adresse;
    private String ville;   

    public Integer getCentreId(){
    return id;
    }

    public String getNom(){
        return nom;
    }

    public void setCentre_id(Integer id) {
        this.id = id;
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
