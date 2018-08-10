package com.emusicstore.dao.impl;

import com.emusicstore.dao.CartItemDao;
import com.emusicstore.model.Cart;
import com.emusicstore.model.CartItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao{

   @Autowired
    SessionFactory sessionFactory;
    @Override
    public void addCartItem(CartItem cartItem) {

        sessionFactory.getCurrentSession().saveOrUpdate(cartItem);
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeCartItem(CartItem cartItem) {
    sessionFactory.getCurrentSession().delete(cartItem);
    sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeAllCartItems(Cart cart) {

        List<CartItem> cartItems=cart.getCartItems();

        for(CartItem item:cartItems)
        {
            removeCartItem(item);
        }

    }

    @Override
    public CartItem getCartItemByProductId(int productId) {
      Session session=sessionFactory.getCurrentSession();

        Query query=session.createQuery("from CartItem  where product.productId=?");
        query.setInteger(0,productId);

        session.flush();


        return (CartItem)query.uniqueResult();
    }
}
