package org.polytech.covidapi.Table;

import java.lang.annotation.Annotation;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
    private boolean admin;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role")
    private Role roles;

    public Users(){
        login = "";
        password = "";
        admin = false;
    }

    public Users(String login, String password, boolean admin){
        this.login = login;
        this.password = password;
        this.admin = admin;
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

    public Role getRole(){
        return roles;
    }

    public void setRole(final Role role){
        this.roles = role;
    }

}
