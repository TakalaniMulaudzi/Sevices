package za.co.protogen.core.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.protogen.adapter.UserMapper;
import za.co.protogen.persistence.models.UserEntity;
import za.co.protogen.persistence.repository.UserRepository;


import java.util.List;
import java.util.stream.Collectors;
import za.co.protogen.persistence.models.UserDomain;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDomain createUser(UserDomain user) {
        UserEntity userEntity = userMapper.domainToEntity(user);
    
        return userMapper.entityToDomain(userEntity);
    }

    @Override
    public UserDomain getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::entityToDomain)
                .orElse(null);
    }

    @Override
    public List<UserDomain> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public UserDomain updateUser(Long id, UserDomain user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            UserEntity updatedEntity = userRepository.save(userMapper.domainToEntity(user));
            return userMapper.entityToDomain(updatedEntity);
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
