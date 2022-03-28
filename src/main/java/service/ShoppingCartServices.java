package service;


import models.CartItem;
import models.Customer;
import models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CartItemRepo;
import repository.ProductRepo;

import java.util.List;

@Service
public class ShoppingCartServices {

    @Autowired
    private CartItemRepo cartItemRepo;
    @Autowired
    private ProductRepo productRepo;

    public List<CartItem> listCartItems(Customer customer){
        return cartItemRepo.findByCustomer(customer);
    }

    public Integer addProduct(int productId, int quantity, Customer customer){
        int addedQuantity = quantity;

           Product product = productRepo.findById(productId).get();
           CartItem cartItem =  cartItemRepo.findByCustomerAndProduct(customer, product);

           if (cartItem != null){
               addedQuantity = cartItem.getQuantity() + 1;//Om cart item inte är tom har varan lagts till tidigare o då ska quantity ändras
               cartItem.setQuantity(addedQuantity);
           } else {
               cartItem = new CartItem();
               cartItem.setQuantity(quantity);
               cartItem.setProduct(product);
               cartItem.setCustomer(customer);
           }
           cartItemRepo.save(cartItem);

            return addedQuantity;

    }

    //OM MAN VILL TA BORT EN ITEM????

    public int removeProduct(int productId, int quantity, Customer customer){
        int reducedQuantity = quantity;

        Product product = productRepo.findById(productId).get();
        CartItem cartItem =  cartItemRepo.findByCustomerAndProduct(customer, product);

        if (cartItem != null){
            reducedQuantity = cartItem.getQuantity() - 1;//Om cart item inte är tom har varan lagts till tidigare o då ska quantity ändras
            cartItem.setQuantity(reducedQuantity);
        } else {
            cartItem = new CartItem();
            cartItem.setQuantity(quantity);
            cartItem.setProduct(product);
            cartItem.setCustomer(customer);
        }
        cartItemRepo.save(cartItem);

        return reducedQuantity;

    }


}
