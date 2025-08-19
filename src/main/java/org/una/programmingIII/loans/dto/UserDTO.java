package org.una.programmingIII.loans.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String password;
    private String email;
    private String identificationNumber;
    private String state;
    private Long roleId;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdate;
}