package com.example.demo.services.mapservices;

import com.example.demo.commands.CustomerForm;
import com.example.demo.converters.CustomerFormToCustomer;
import com.example.demo.domain.Customer;
import com.example.demo.domain.DomainObject;
import com.example.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@Profile("map")
public class CustomerServiceImpl extends AbstractMapService implements CustomerService {

    private CustomerFormToCustomer customerFormToCustomer;

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public Customer getById(Integer id) {
        return (Customer) super.getById(id);
    }

    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        return (Customer) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }

    @Override
    public Customer saveOrUpdateCustomerForm(CustomerForm customerForm) {
        Customer customer = customerFormToCustomer.convert(customerForm);

        if (customer.getUser().getId() != null) {
            Customer existingCustomer = getById(customer.getId());
            customer.getUser().setEnabled(existingCustomer.getUser().getEnabled());
        }
        return saveOrUpdate(customer);
    }


    @Autowired
    public void setCustomerFormToCustomer(CustomerFormToCustomer customerFormToCustomer) {
        this.customerFormToCustomer = customerFormToCustomer;
    }

}
