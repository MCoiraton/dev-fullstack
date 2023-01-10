package org.polytech.covidapi.Repository;

import java.util.List;
import java.util.Optional;
import org.polytech.covidapi.Table.Users;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<Users, Long> {
    List<Users> findAll();
    Optional<Users> findByLogin(final String login);
}
