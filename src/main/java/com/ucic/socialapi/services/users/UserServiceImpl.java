package com.ucic.socialapi.services.users;

import com.ucic.socialapi.exceptions.NotFoundException;
import com.ucic.socialapi.models.entity.User;
import com.ucic.socialapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByDocumentNumber(String documentNumber) {
        return userRepository.findByDocumentNumber(documentNumber).orElseThrow(
                () -> new NotFoundException("Usuario no encontrado.")
        );
    }

}
