package com.emusicstore.service.impl;

import com.emusicstore.dao.CustomerDao;
import com.emusicstore.model.Customer;
import com.emusicstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    public void addCustomer(Customer customer) {

        customerDao.addCustomer(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        return  customerDao.getCustomerById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    @Override
    public Customer getCustomerByUserName(String username) {
        return  customerDao.getCustomerByUserName(username);
    }
}
