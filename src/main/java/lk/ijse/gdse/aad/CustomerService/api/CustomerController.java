package lk.ijse.gdse.aad.CustomerService.api;

import jakarta.validation.Valid;
import lk.ijse.gdse.aad.CustomerService.dto.CustomerDTO;
import lk.ijse.gdse.aad.CustomerService.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin("*")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    CustomerDTO saveCustomer(@Valid @RequestBody CustomerDTO customerDto, Errors errors) {
        //Validation
        if(errors.hasFieldErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,errors
                    .getFieldErrors().get(0).getDefaultMessage());
        }
        return customerService.saveCustomer(customerDto);
    }

    @GetMapping(value = "{code:[A-Fa-f0-9\\-]{36}}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CustomerDTO> getSelectedCustomer(@Valid  @PathVariable String code) {
        CustomerDTO selectedCustomer = customerService.getSelectedCustomer(code);
        return selectedCustomer != null ? ResponseEntity.ok(selectedCustomer) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{code:[A-Fa-f0-9\\-]{36}}")
    void deleteCustomer(@Valid @PathVariable String code) {
        customerService.deleteCustomer(code);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "{code:[A-Fa-f0-9\\-]{36}}" )
    void updateCustomer(@Valid @PathVariable String code, @RequestBody CustomerDTO customer,Errors errors) {
        //Validation
        if(errors.hasFieldErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    errors.getFieldErrors().get(0).getDefaultMessage());
        }

        customer.setCustomerCode(code);
        customerService.updateCustomer(customer);
    }

}
