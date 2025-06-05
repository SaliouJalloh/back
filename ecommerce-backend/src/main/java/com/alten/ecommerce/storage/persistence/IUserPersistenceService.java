package com.alten.ecommerce.storage.persistence;

import com.alten.ecommerce.storage.model.User;

public interface IUserPersistenceService {

    User findUserByEmail(String email);

    User saveUser(User user);

    boolean existsByEmail(String email);
}