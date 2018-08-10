package com.emusicstore.dao.impl;

import com.emusicstore.dao.CartDao;
import com.emusicstore.model.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CartDaoImpl implements CartDao{
   @Autowired
    SessionFactory sessionFactory;

    @Override
    public Cart getCartById(int cartId) {
        return sessionFactory.getCurrentSession().get(Cart.class,cartId);
    }

    @Override
    public void update(Cart cart) {

        int cartId=cart.getCartId();



    }



}
