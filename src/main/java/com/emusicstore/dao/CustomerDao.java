package com.emusicstore.dao;

import com.emusicstore.model.Customer;

import java.util.List;

public interface CustomerDao {


    void addCustomer(Customer customer);


    Customer getCustomerById(int id);
    Customer getCustomerByUserName(String username);
    List<Customer> getAllCustomers();
}
