package org.polytech.covidapi.Config;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.access.vote.RoleHierarchyVoter;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private static final Logger log = LoggerFactory.getLogger(SecurityConfig.class);

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, UserDetailsService userDetailsService) throws Exception{
        http
        .authorizeHttpRequests((authz) -> authz
        .antMatchers("/api/**").permitAll()
        .antMatchers("/admin/**").hasAuthority("ADMIN"))
        .httpBasic(Customizer.withDefaults())
            .cors().disable()
            .csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }

    @Bean
    AccessDecisionVoter hierarchyVoter(){
        RoleHierarchy hierarchy=new RoleHierarchyImpl();
        ((RoleHierarchyImpl) hierarchy).setHierarchy("ROLE_ADMIN > ROLE_STAFF\n"+
        "ROLE_STAFF > ROLE_USER\n"+
        "ROLE_USER > ROLE_GUEST");
        return new RoleHierarchyVoter(hierarchy);
        }

    @Bean
    public PasswordEncoder passwordEncoder(){
       return new BCryptPasswordEncoder();
    }
    
}
