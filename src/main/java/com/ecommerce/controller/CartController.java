package com.ecommerce.controller;

import com.ecommerce.entity.Cart;
import com.ecommerce.entity.Client;
import com.ecommerce.entity.Product;
import com.ecommerce.service.CartService;
import com.ecommerce.service.ClientService;
import com.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductService productService;

    @PostMapping("/{clientId}/{productId}/{quantity}")
    public Cart addProductToCart(@PathVariable Long clientId, @PathVariable Long productId, @PathVariable int quantity) {
        Client client = clientService.getClientById(clientId);
        Product product = productService.getProductById(productId);

        Cart cart = new Cart();
        cart.setClient(client);
        cart.setProduct(product);
        cart.setQuantity(quantity);
        cart.setDelivered(false);

        return cartService.saveCart(cart);
    }

    @DeleteMapping("/{cartId}")
    public void removeProductFromCart(@PathVariable Long cartId) {
        cartService.deleteCart(cartId);
    }

    @GetMapping("/{clientId}")
    public List<Cart> getCartByClientId(@PathVariable Long clientId) {
        return cartService.getCartsByClientId(clientId);
    }
}
