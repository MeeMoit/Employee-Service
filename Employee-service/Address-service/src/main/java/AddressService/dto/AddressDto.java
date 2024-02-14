package AddressService.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddressDto {
        private int id;
        private String lane1;
        private String lane2;
        private String state;
        private String zip;
    }
