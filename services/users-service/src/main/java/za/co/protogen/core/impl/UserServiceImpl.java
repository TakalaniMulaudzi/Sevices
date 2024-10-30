package za.co.protogen.core.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import za.co.protogen.adapter.UserMapper;
import za.co.protogen.persistence.models.UserDomain;
import za.co.protogen.persistence.models.UserEntity;
import za.co.protogen.persistence.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDomain createUser(UserDomain user) {
        logger.info("Creating a new user with details: {}", user);
        UserEntity userEntity = userMapper.domainToEntity(user);
        UserEntity savedEntity = userRepository.save(userEntity);
        logger.info("User created with ID: {}", savedEntity.getId());
        return userMapper.entityToDomain(savedEntity);
    }

    @Override
    public UserDomain getUserById(Long id) {
        logger.debug("Fetching user with ID: {}", id);
        return userRepository.findById(id)
                .map(entity -> userMapper.entityToDomain(entity))
                .orElse(null);
    }

    @Override
    public List<UserDomain> getAllUsers() {
        logger.debug("Fetching all users");
        return userRepository.findAll()
                .stream()
                .map(userMapper::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public UserDomain updateUser(Long id, UserDomain user) {
        logger.info("Updating user with ID: {}", id);
        if (userRepository.existsById(id)) {
            user.setId(id);
            UserEntity updatedEntity = userRepository.save(userMapper.domainToEntity(user));
            logger.info("User updated with new details: {}", user);
            return userMapper.entityToDomain(updatedEntity);
        } else {
            logger.warn("User with ID {} not found", id);
            return null;
        }
    }

    @Override
    public void deleteUser(Long id) {
        logger.warn("Deleting user with ID: {}", id);
        userRepository.deleteById(id);
        logger.info("User with ID {} deleted", id);
    }
}