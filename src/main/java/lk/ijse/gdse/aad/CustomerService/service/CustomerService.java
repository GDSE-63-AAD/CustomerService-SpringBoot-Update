package lk.ijse.gdse.aad.CustomerService.service;

import lk.ijse.gdse.aad.CustomerService.dto.CustomerDTO;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customer);
    CustomerDTO getSelectedCustomer(String code);
    void updateCustomer(CustomerDTO customer);
    void deleteCustomer(String code);
}
