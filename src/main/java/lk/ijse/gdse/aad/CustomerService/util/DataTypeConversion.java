package lk.ijse.gdse.aad.CustomerService.util;
import lk.ijse.gdse.aad.CustomerService.dto.CustomerDTO;
import lk.ijse.gdse.aad.CustomerService.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DataTypeConversion {

    private final ModelMapper modelMapper;

    DataTypeConversion(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

   public CustomerDTO getCustomerDTO(Customer customer){
        return modelMapper.map(customer, CustomerDTO.class);
    }
    public Customer getCustomerEntity(CustomerDTO customerDTO){
        return modelMapper.map(customerDTO, Customer.class);
    }
}
