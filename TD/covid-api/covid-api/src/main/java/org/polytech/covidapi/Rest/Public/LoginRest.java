package org.polytech.covidapi.Rest.Public;

import org.polytech.covidapi.Repository.LoginRepository;
import org.polytech.covidapi.Services.UserService;
import org.polytech.covidapi.Table.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequestMapping("/public")
public class LoginRest {

   Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private final LoginRepository repository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    
    public LoginRest(LoginRepository repository, UserService userService, PasswordEncoder passwordEncoder){
        this.repository = repository;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;

    }

    @GetMapping()
    public ResponseEntity<Void> login(){
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "signup")
    public void addUser(@RequestBody Users newUser){
       newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
       userService.addUsers(newUser);
       
    }

    @PostMapping(path="login")
    public ResponseEntity logUser(@RequestBody Users user){
        UserDetails test = userService.loadUserByUsername(user.getLogin()); //On récupère le hash stocké dans la bdd pour le login demandé
        log.info(test.getPassword());
        log.info(user.getPassword());
        if (passwordEncoder.matches(user.getPassword(), test.getPassword())) { //On test si le hash du password de la requête est le même que le hash du password stocké
            return new ResponseEntity<>("Utilisateur connecté avec succès !", HttpStatus.OK ); //Si c'est bon OK 
        }
        else return new ResponseEntity<>("Impossible de se connecter. Nom d'utilisateur ou mot de passe incorrect", HttpStatus.FORBIDDEN ); //Sinon on renvoie un message d'erreur
    }


}
