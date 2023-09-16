package lk.ijse.gdse.aad.CustomerService.service;

import lk.ijse.gdse.aad.CustomerService.dto.CustomerDTO;
import lk.ijse.gdse.aad.CustomerService.entity.Customer;
import lk.ijse.gdse.aad.CustomerService.exception.InvalidException;
import lk.ijse.gdse.aad.CustomerService.exception.NotFoundException;
import lk.ijse.gdse.aad.CustomerService.persistance.CustomerDAO;
import lk.ijse.gdse.aad.CustomerService.util.DataTypeConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CustomerServiceIMPL implements CustomerService{

    @Autowired
    private DataTypeConversion dataTypeConversion;
    @Autowired
    private CustomerDAO customerDAO;


    @Override
    public CustomerDTO saveCustomer(CustomerDTO customer) {
        return dataTypeConversion.getCustomerDTO(customerDAO
                .save(dataTypeConversion.getCustomerEntity(customer)));
    }

    @Override
    public CustomerDTO getSelectedCustomer(String code) {
        if(!customerDAO.existsById(code)) throw new InvalidException("Customer not found");
        return dataTypeConversion.getCustomerDTO((customerDAO.getCustomerByCustomerCode(code)));
    }

    @Override
    public void updateCustomer(CustomerDTO customer) {
        Optional<Customer> tmpCustomer = customerDAO.findById(customer.getCustomerCode());
        if(!tmpCustomer.isPresent()) throw new NotFoundException("Customer Not found");
        tmpCustomer.get().setCustomerName(customer.getCustomerName());
        tmpCustomer.get().setCustomerAddress(customer.getCustomerAddress());
        tmpCustomer.get().setCustomerEmail(customer.getCustomerEmail());
    }

    @Override
    public void deleteCustomer(String code) {
        if(!customerDAO.existsById(code)) throw new NotFoundException("Invalid customer");
        customerDAO.deleteByCustomerCode(code);
    }
}
