package com.ucic.socialapi.services.users;

import com.ucic.socialapi.models.entity.User;

public interface UserService {

    public User findByDocumentNumber(String documentNumber);

}
