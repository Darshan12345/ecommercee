package com.emusicstore.dao.impl;

import com.emusicstore.dao.CustomerDao;
import com.emusicstore.model.Authorities;
import com.emusicstore.model.Cart;
import com.emusicstore.model.Customer;
import com.emusicstore.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public void addCustomer(Customer customer) {

       Session session= sessionFactory.getCurrentSession();

       customer.getBillingAddress().setCustomer(customer);
       customer.getShippingAddress().setCustomer(customer);

        session.saveOrUpdate(customer);

        session.saveOrUpdate(customer.getBillingAddress());


        session.saveOrUpdate(customer.getShippingAddress());

        Users user=new Users();
        user.setUsername(customer.getUsername());
        user.setPassword(customer.getPassword());
        user.setEnabled(true);
        user.setCustomerId(customer.getCustomerId());

        Authorities authorities=new Authorities();

        authorities.setUsername(customer.getUsername());
        authorities.setAuthority("ROLE_USER");

        session.saveOrUpdate(user);
        session.saveOrUpdate(authorities);

        Cart newCart=new Cart();
        newCart.setCustomer(customer);

        customer.setCart(newCart);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(newCart);
        session.flush();
    }

    @Override
    public Customer getCustomerById(int id) {
        return sessionFactory.getCurrentSession().get(Customer.class,id);
    }

    @Override
    public Customer getCustomerByUserName(String username) {

        Session session=sessionFactory.getCurrentSession();

        Query query=session.createQuery("from Customer  where username=?");
        query.setString(0,username);

        return (Customer)query.uniqueResult();
    }

    @Override
    public List<Customer> getAllCustomers() {

        List<Customer> query=sessionFactory.getCurrentSession().createQuery("from Customer").list();

        return query;
    }
}
