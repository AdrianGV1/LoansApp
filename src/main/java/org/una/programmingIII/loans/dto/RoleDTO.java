package org.una.programmingIII.loans.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {
    private Long id;
    private String name;
    private String state;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdate;

    private List<Long> userIds;
}
