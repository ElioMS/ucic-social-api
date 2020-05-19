package com.ucic.socialapi.services.users;

import com.ucic.socialapi.models.entity.User;

public interface UserService {

    boolean existsUserByDocumentNumber(String documentNumber);
    User createAnonymousUser(String documentNumber);
    User findByDocumentNumber(String documentNumber);

}
