package com.emusicstore.controller;


import com.emusicstore.model.Cart;
import com.emusicstore.model.CartItem;
import com.emusicstore.model.Customer;
import com.emusicstore.model.Product;
import com.emusicstore.service.CartItemService;
import com.emusicstore.service.CartService;
import com.emusicstore.service.CustomerService;
import com.emusicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rest/cart")
public class CartResources {

@Autowired
private CartService cartService;
@Autowired
    CustomerService customerService;

@Autowired
ProductService productService;
@Autowired
    CartItemService cartItemService;
    @RequestMapping("/{cartId}")
    public @ResponseBody
    Cart getCartById(@PathVariable(value = "cartId")int cartId)
    {
        return cartService.getCartById(cartId);
    }

    @RequestMapping(value="/add/{productId}",method = RequestMethod.PUT)
    public void addItem(@PathVariable(value = "productId")int productId, @AuthenticationPrincipal User activeUser)
    {
        Customer customer=customerService.getCustomerByUserName(activeUser.getUsername());
        Cart cart=customer.getCart();
        Product product=productService.getProductById(productId);


        List<CartItem> cartItems=cart.getCartItems();

        for(CartItem item:cartItems)
        {
            if(item.getProduct().getProductId()==productId)
            {
                item.setQuantity(item.getQuantity()+1);
                item.setTotalPrice(product.getProductPrice()*item.getQuantity());
                cartItemService.addCartItem(item);
                return;
            }
        }

        CartItem item=new CartItem();
        item.setProduct(product);
        item.setTotalPrice(product.getProductPrice()*item.getQuantity());
        item.setCart(cart);
        cartItemService.addCartItem(item);
    }


    @RequestMapping(value = "/remove/{productId}",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable(value="productId")int productId)
    {

        CartItem cartItem=cartItemService.getCartItemByProductId(productId);

        cartItemService.removeCartItem(cartItem);
    }

    @RequestMapping( value = "/{cartId}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void clearCart(@PathVariable(value = "cartId")int cartid)
    {
        Cart cart=cartService.getCartById(cartid);

        cartItemService.removeAllCartItems(cart);
    }

        @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "Illegal request")
    public void   handleClientException(Exception e)
        {

        }



    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR,reason = "Illegal request")
    public void   handleException(Exception e)
    {

    }

}
