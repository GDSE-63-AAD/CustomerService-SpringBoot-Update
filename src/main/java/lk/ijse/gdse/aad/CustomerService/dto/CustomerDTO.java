package lk.ijse.gdse.aad.CustomerService.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements Serializable {
    private String customerCode;
    private String customerName;
    private String customerAddress;
    private String customerEmail;

    public CustomerDTO(String customerName, String customerAddress, String customerEmail) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
    }
}

