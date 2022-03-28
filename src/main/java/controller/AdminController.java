package controller;

import models.CartItem;
import models.Customer;
import models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.CartItemRepo;
import repository.CustomerRepo;
import repository.ProductRepo;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private CartItemRepo cartItemRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ProductRepo productRepo;


                //CART ITEMS
    @GetMapping(value = "/getAllCartItems")
    public List<CartItem> getAllItems (){
        return cartItemRepo.findAll();
    }

    @PostMapping(value="/saveCartItem")
    public String saveCartItem(@RequestBody CartItem cartItem){
        cartItemRepo.save(cartItem);
        return "Cart Item Saved...";
    }

    @PutMapping(value = "updateCartItem/{id}")
    public String updateCartItem(@PathVariable int cartItemId, @RequestBody CartItem cartItem){
        CartItem updatedCartItem = cartItemRepo.findById(cartItemId).get();

        updatedCartItem.setCustomer(cartItem.getCustomer());
        updatedCartItem.setProduct(updatedCartItem.getProduct());
        updatedCartItem.setQuantity(cartItem.getQuantity());
        cartItemRepo.save(updatedCartItem);
        return "Updated Cart Item by Id...." + cartItemId;
    }

    @DeleteMapping(value = "/deleteCartItem/{id}")
    public String deleteCartItem(@PathVariable int cartItemId){
        CartItem deleteCartItem = cartItemRepo.findById(cartItemId).get();
        cartItemRepo.delete(deleteCartItem);
        return "Deleted Cart Item by Id" + cartItemId;
    }

                   //CUSTOMER

    @GetMapping(value = "/getAllCustomers")
    public List<Customer> getAllCustomers (){
        return customerRepo.findAll();
    }

    @PostMapping(value="/saveCustomer")
    public String saveCustomer(@RequestBody Customer customer){
        customerRepo.save(customer);
        return "Customer Saved...";
    }

    @PutMapping(value = "updateCustomer/{id}")
    public String updateCustomer(@PathVariable int customerId, @RequestBody Customer customer){

        Customer updatedCustomer = customerRepo.findById(customerId).get();

        updatedCustomer.setCartItem(customer.getCartItem());
        updatedCustomer.setProduct(customer.getProduct());
        updatedCustomer.setFirstName(customer.getFirstName());
        updatedCustomer.setLastName(customer.getLastName());
        updatedCustomer.setHomeAdress(customer.getHomeAdress());
        updatedCustomer.setEmail(customer.getEmail());

        customerRepo.save(updatedCustomer);

        return "Updated Customer....";
    }

    @DeleteMapping(value = "/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable int customerId){
        Customer deleteCustomer = customerRepo.findById(customerId).get();
        customerRepo.delete(deleteCustomer);
        return "Deleted Customer by Id" + customerId;
    }

                //PRODUCT

    @GetMapping(value = "/getAllProducts")
    public List<Product> getAllProducts () {
        return productRepo.findAll();
    }

    @PostMapping(value="/saveProduct")
    public String saveProduct (@RequestBody Product product) {
        productRepo.save(product);
        return "Product has been saved...";
    }

    @PutMapping(value = "updateProduct/{id}")
    public String updateProduct(@PathVariable int productId, @RequestBody Product product){

        Product updatedProduct = productRepo.findById(productId).get();

        updatedProduct.setName(product.getName());
        updatedProduct.setPrice(product.getPrice());
        updatedProduct.setDescription(product.getDescription());
        updatedProduct.setStockQuantity(product.getStockQuantity());
        updatedProduct.setImg(product.getImg());

        productRepo.save(updatedProduct);

        return "Updated Product by Id...." + productId;
    }

    @DeleteMapping(value = "/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int productId){

        Product deleteProduct = productRepo.findById(productId).get();
        productRepo.delete(deleteProduct);

        return "Deleted Product by Id" + productId;
    }


}

