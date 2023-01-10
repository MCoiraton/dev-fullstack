package org.polytech.covidapi.Rest;

import org.apache.catalina.User;
import org.polytech.covidapi.Repository.LoginRepository;
import org.polytech.covidapi.Services.UserService;
import org.polytech.covidapi.Table.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginRest {

    private final LoginRepository repository;
    private final UserService userService;
    
    public LoginRest(LoginRepository repository, UserService userService){
        this.repository = repository;
        this.userService = userService;
    }

    @GetMapping("test")
    public ResponseEntity<Void> login(){
        return ResponseEntity.ok().build();
    }

    @PostMapping()
    public void addUser(@RequestBody Users newUser){
       newUser.setPassword(userService.passwordEncoder.encode(newUser.getPassword()));
       userService.addUsers(newUser);
    }
}
