package org.polytech.covidapi.Services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.polytech.covidapi.Repository.LoginRepository;
import org.polytech.covidapi.Table.Role;
import org.polytech.covidapi.Table.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService implements UserDetailsService{

    private static Logger log = LoggerFactory.getLogger(UserService.class);
    private final LoginRepository loginRepository;
    public final PasswordEncoder passwordEncoder;
    
    @Autowired
    public UserService(final LoginRepository loginRepository, PasswordEncoder passwordEncoder){
        this.loginRepository = loginRepository;
        this.passwordEncoder = passwordEncoder;
   
    }

    public Users addUsers(Users user){
        loginRepository.save(user);
        return user;
    }

    @PostConstruct
    public void createUserDefault(){
        if(!loginRepository.findByLogin("user").isPresent() && !loginRepository.findByLogin("admin").isPresent()){
            log.info("Création de l'utilisateur par défaut");
            Users users = new Users();
            Role roleUser = new Role("USER");
            users.setLogin("user");
            users.setPassword(passwordEncoder.encode("password"));
            users.setAdmin(false);
            users.setRole(roleUser);
            this.loginRepository.save(users);
            log.info("Création de l'admin par défaut");
            Users admin = new Users();
            Role roleAdmin = new Role("ADMIN");
            admin.setLogin("admin");
            admin.setPassword(passwordEncoder.encode("password"));
            admin.setAdmin(true);
            admin.setRole(roleAdmin);
            this.loginRepository.save(admin);
        }
    }
    

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(final String login) 
        throws UsernameNotFoundException {
            log.info("Récupération de { ", login);

            Optional<Users> optionalUser = loginRepository.findByLogin(login);
            if (optionalUser.isPresent()){
                Users user = optionalUser.get();
                return new User(user.getLogin(), user.getPassword(), Collections.singletonList(user.getRole().getRole()).stream().map(SimpleGrantedAuthority::new).toList());
            }
            else {
                throw new UsernameNotFoundException("L'utilisateur" + login + "n'existe pas");
            }
        }
    
    @Transactional(readOnly = true)
    public UserDetails findUser(final String login, String password) 
    throws UsernameNotFoundException {
        log.info("Récupération de { ", login);

        Optional<Users> optionalUser = loginRepository.findByLogin(login);
        if (optionalUser.isPresent() && optionalUser.get().getPassword()==password){
            Users user = optionalUser.get();
            return new User(user.getLogin(), user.getPassword(), Collections.singletonList(user.getRole().getRole()).stream().map(SimpleGrantedAuthority::new).toList());
        }
        else {
            throw new UsernameNotFoundException("L'utilisateur" + login + "n'existe pas ou le mdp est erroné");
        }
    }
    
}
