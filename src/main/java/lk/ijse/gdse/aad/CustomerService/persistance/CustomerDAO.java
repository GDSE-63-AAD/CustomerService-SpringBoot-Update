package lk.ijse.gdse.aad.CustomerService.persistance;

import lk.ijse.gdse.aad.CustomerService.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends JpaRepository<Customer,String> {
    Customer save(Customer customer);
    Customer getCustomerByCustomerCode(String code);
    void deleteByCustomerCode(String code);
}
