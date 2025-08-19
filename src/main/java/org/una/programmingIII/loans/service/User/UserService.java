package org.una.programmingIII.loans.service.User;

import java.util.List;
import java.util.Optional;
import org.una.programmingIII.loans.dto.UserDTO;

public interface UserService {
    List<UserDTO> getAllUsers();

    Optional<UserDTO> getUserByEmail(String email);

    UserDTO createUser(UserDTO userDTO);

    Optional<UserDTO> updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);
}
