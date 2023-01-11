package org.polytech.covidapi.Repository;

import java.util.List;
import java.util.Optional;
import org.polytech.covidapi.Table.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LoginRepository extends JpaRepository<Users, Integer> {
    List<Users> findAll();
    Optional<Users> findByLogin(String login);
}
