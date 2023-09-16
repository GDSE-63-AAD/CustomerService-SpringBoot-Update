package lk.ijse.gdse.aad.CustomerService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Customer implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String customerCode;
    @Column(nullable = false)
    private String customerName;
    @Column(nullable = false)
    private String customerAddress;
    @Column(nullable = false)
    private String customerEmail;
}
