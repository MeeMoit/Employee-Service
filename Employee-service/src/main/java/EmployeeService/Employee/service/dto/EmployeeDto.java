package EmployeeService.Employee.service.dto;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeDto {
        private int id;
        private String name;
        private String email;
        private String bloodGroup;

        private AddressDto addressDto;
}

