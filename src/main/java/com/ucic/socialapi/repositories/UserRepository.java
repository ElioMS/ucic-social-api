package com.ucic.socialapi.repositories;

import com.ucic.socialapi.models.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByDocumentNumber(String documentNumber);
    boolean existsUserByDocumentNumber(String documentNumber);

}
