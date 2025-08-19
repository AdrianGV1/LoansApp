package org.una.programmingIII.loans.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDTO {
    private Long id;
    private String documentType;
    private String filePath;
    private String state;
    private Long creditApplicationId;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdate;
}
