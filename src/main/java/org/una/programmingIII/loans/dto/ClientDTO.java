package org.una.programmingIII.loans.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    private Long id;
    private String name;
    private String email;
    private String identificationNumber;
    private String state;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdate;

    private List<CreditApplicationDTO> creditApplications;
}
