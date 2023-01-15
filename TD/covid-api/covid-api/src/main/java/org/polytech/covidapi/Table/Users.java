package org.polytech.covidapi.Table;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Users {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    private String login;
    private String password;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role")
    private Role roles;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="centre_id")
    private Centre centre;

    public Users(){
        Role roles = new Role("MEDECIN");
        login = "";
        password = "";
       
    }

    public Users(String login, String password){
        this.login = login;
        this.password = password;
    }

    public int getId(){
        return id;
    }

    public void setId(final int id){
        this.id = id;
    }

    public String getLogin(){
        return login;
    }

    public void setLogin(final String login){
        this.login = login;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(final String password){
        this.password = password;
    }

    public Role getRole(){
        return roles;
    }

    public void setRole(final Role role){
        this.roles = role;
    }

    public Centre getCentre() {
        return centre;
    }

    public void setCentre(Centre centre) {
        this.centre = centre;
    }

}
