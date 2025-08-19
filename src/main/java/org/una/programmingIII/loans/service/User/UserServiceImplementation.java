package org.una.programmingIII.loans.service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.programmingIII.loans.dto.ClientDTO;
import org.una.programmingIII.loans.dto.UserDTO;
import org.una.programmingIII.loans.model.Client;
import org.una.programmingIII.loans.model.User;
import org.una.programmingIII.loans.repository.UserRepository;
import org.una.programmingIII.loans.transformer.GenericMapper;
import org.una.programmingIII.loans.transformer.GenericMapperFactory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GenericMapperFactory mapperFactory;

    @Override
    public List<UserDTO> getAllUsers() {
        GenericMapper<User, UserDTO> userMapper = mapperFactory.createMapper(User.class, UserDTO.class);
        return userRepository.findAll().stream()
                .map(userMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> getUserByEmail(String email) {
        GenericMapper<User, UserDTO> userMapper = mapperFactory.createMapper(User.class, UserDTO.class);
        return Optional.ofNullable(userRepository.findByEmail(email))
                .map(userMapper::convertToDTO);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        GenericMapper<User, UserDTO> userMapper = mapperFactory.createMapper(User.class, UserDTO.class);
        User user = userMapper.convertToEntity(userDTO);
        User savedUser = userRepository.save(user);
        return userMapper.convertToDTO(savedUser);
    }

    @Override
    public Optional<UserDTO> updateUser(Long id, UserDTO userDTO) {
        GenericMapper<User, UserDTO> userMapper = mapperFactory.createMapper(User.class, UserDTO.class);
        return userRepository.findById(id)
                .map(existingUser -> {
                    User updatedUser = userMapper.convertToEntity(userDTO);
                    updatedUser.setId(id);
                    updatedUser.setCreatedAt(existingUser.getCreatedAt());
                    User savedUser = userRepository.save(updatedUser);
                    return userMapper.convertToDTO(savedUser);
                });
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
