package com.alten.ecommerce.storage.persistence;

import com.alten.ecommerce.storage.entity.UserEntity;
import com.alten.ecommerce.storage.mapper.IUserPersistenceMapper;
import com.alten.ecommerce.storage.model.User;
import com.alten.ecommerce.storage.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserPersistenceService implements IUserPersistenceService {
    private final UserRepository userRepository;
    private final IUserPersistenceMapper persistenceMapper;

    @Override
    public User findUserByEmail(String email) {
        UserEntity userEntity = this.userRepository.findByEmail(email).orElseThrow(() -> {
            log.error("Not user found with email: {}", email);
            return new EntityNotFoundException("User not found");
        });
        return this.persistenceMapper.toModel(userEntity);
    }

    @Override
    public User saveUser(User user) {
        UserEntity customerEntity = persistenceMapper.toEntity(user);
        UserEntity savedCustomer = userRepository.save(customerEntity);
        persistenceMapper.toModel(savedCustomer);
        return user;
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}