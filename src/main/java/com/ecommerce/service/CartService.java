package com.ecommerce.service;

import com.ecommerce.entity.Cart;
import com.ecommerce.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Cart getCartById(Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    public List<Cart> getCartsByClientId(Long clientId) {
        return cartRepository.findByClientId(clientId);
    }

    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }
}
