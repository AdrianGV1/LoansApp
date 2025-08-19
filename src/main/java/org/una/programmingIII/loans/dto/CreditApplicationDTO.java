package org.una.programmingIII.loans.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditApplicationDTO {
    private Long id;
    private Double amount;
    private Integer term;
    private String purpose;
    private String status;
    private ClientDTO applicant;
    private List<DocumentDTO> documents;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdate;
}
