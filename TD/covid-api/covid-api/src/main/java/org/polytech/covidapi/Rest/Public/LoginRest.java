package org.polytech.covidapi.Rest.Public;

import org.polytech.covidapi.Repository.LoginRepository;
import org.polytech.covidapi.Services.UserService;
import org.polytech.covidapi.Table.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class LoginRest {

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
}
