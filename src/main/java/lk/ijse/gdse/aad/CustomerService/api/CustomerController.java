package lk.ijse.gdse.aad.CustomerService.api;

import lk.ijse.gdse.aad.CustomerService.dto.CustomerDTO;
import lk.ijse.gdse.aad.CustomerService.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin("*")
public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json",produces = "application/json")
    CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDto){
        //ToDo: Error handling
        return customerService.saveCustomer(customerDto);
    }

    @GetMapping(value = "{code}",produces = MediaType.APPLICATION_JSON_VALUE)
    CustomerDTO getSelectedCustomer( @PathVariable String code){
        return customerService.getSelectedCustomer(code);
    }

    @DeleteMapping(value =  "{code}")
    void deleteCustomer ( @PathVariable String code){
        customerService.deleteCustomer(code);
    }

    @PatchMapping(value = "{code}")
    void updateCustomer(@PathVariable String code, @RequestBody CustomerDTO customer){
        //ToDo: Error handling
        customer.setCustomerCode(code);
        customerService.updateCustomer(customer);
    }
}
