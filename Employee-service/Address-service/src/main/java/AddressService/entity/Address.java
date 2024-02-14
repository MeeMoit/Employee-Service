package AddressService.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "lane1")
    private String lane1;
    @Column(name = "lane2")
    private String lane2;
    @Column(name = "state")
    private String state;
    @Column(name = "zip")
    private String zip;

}
