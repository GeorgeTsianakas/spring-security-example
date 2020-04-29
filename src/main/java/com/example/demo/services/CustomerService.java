package com.example.demo.services;

import com.example.demo.commands.CustomerForm;
import com.example.demo.domain.Customer;

public interface CustomerService extends CRUDService<Customer> {
    Customer saveOrUpdateCustomerForm(CustomerForm customerForm);
}
