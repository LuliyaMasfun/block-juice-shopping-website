package controller;

import models.CartItem;
import models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.CartItemRepo;
import repository.CustomerRepo;
import repository.ProductRepo;
import service.ShoppingCartServices;

import java.util.List;

@RestController
public class ShoppingCartRestController {

    @Autowired
    private CartItemRepo cartItemRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ShoppingCartServices shoppingCartServices;


    @GetMapping(value = "/getAllCartItems")
    public List<CartItem> showCart (){
        return cartItemRepo.findAll();
    }

    @PostMapping(value="/cart/add/{productId}/{quantity}/")
    public String addProductToCart(@RequestBody CartItem cartItem){
        int addedQuantity = ShoppingCartServices.addProduct(productId, quantity, customer);
        return addedQuantity + "item(s) of this product has been added to your shopping cart.";
    }

    @PutMapping(value = "updateCartItem/{id}")
    public String updateQuantity(@PathVariable int cartItemId, @RequestBody CartItem cartItem){
        CartItem updatedCartItem = cartItemRepo.findById(cartItemId).get();

        updatedCartItem.setQuantity(cartItem.getQuantity());
        cartItemRepo.save(updatedCartItem);
        return "Updated Quantity of Cart Item" + cartItemId;
    }

    @DeleteMapping(value = "/deleteCartItem/{id}")
    public String removeProductFromCart(@PathVariable int cartItemId){
        CartItem deleteCartItem = cartItemRepo.findById(cartItemId).get();
        cartItemRepo.delete(deleteCartItem);
        return "Deleted Cart Item by Id" + cartItemId;
    }
}
