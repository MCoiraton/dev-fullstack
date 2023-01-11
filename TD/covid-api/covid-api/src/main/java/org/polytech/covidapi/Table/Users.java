package org.polytech.covidapi.Table;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private boolean admin;

    @ElementCollection
    @CollectionTable
    private List<String> roles;

    public Users(){
        login = "";
        password = "";
        admin = false;
        roles = List.of("USER");
    }

    public Users(String login, String password, boolean admin){
        this.login = login;
        this.password = password;
        this.admin = admin;
        roles = List.of("USER");
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

    public boolean getAdmin(){
        return admin;
    }

    public void setAdmin(final boolean admin){
        this.admin = admin;
    }

    public List<String> getRole(){
        return roles;
    }

    public void setRole(final List<String> role){
        this.roles = role;
    }

}
