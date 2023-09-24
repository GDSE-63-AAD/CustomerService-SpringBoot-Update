package lk.ijse.gdse.aad.CustomerService.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements Serializable {
    @Null(message = "Customer Code will auto generate")
    private String customerCode;
    @NotNull(message = "Customer name cannot be empty")
    @Pattern(regexp = "[A-Za-z ]+")
    private String customerName;
    @NotNull(message = "Customer address cannot be empty")
    private String customerAddress;
    @NotNull(message = "Customer email cannot be empty")
    @Email
    private String customerEmail;

    public CustomerDTO(String customerName, String customerAddress, String customerEmail) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
    }
}

