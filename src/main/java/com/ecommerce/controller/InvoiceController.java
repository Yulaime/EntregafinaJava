package com.ecommerce.controller;

import com.ecommerce.entity.Cart;
import com.ecommerce.entity.Invoice;
import com.ecommerce.service.CartService;
import com.ecommerce.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/invoices")
public class InvoiceController {

    @Autowired
    private CartService cartService;

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping
    public Invoice generateInvoice(@RequestBody Long clientId) {
        List<Cart> cartItems = cartService.getCartsByClientId(clientId);

        if (cartItems.isEmpty()) {
            throw new RuntimeException("El carrito está vacío.");
        }

        Invoice invoice = new Invoice();
        invoice.setClient(cartItems.get(0).getClient());
        invoice.setCreatedAt(LocalDateTime.now());

        double total = 0;
        for (Cart item : cartItems) {
            total += item.getProduct().getPrice() * item.getQuantity();
            item.setDelivered(true);
            cartService.saveCart(item); // Actualizar el estado del carrito
        }
        invoice.setTotal(total);

        return invoiceService.saveInvoice(invoice);
    }

    @GetMapping("/{clientId}")
    public Invoice getLastInvoice(@PathVariable Long clientId) {
        return invoiceService.getLastInvoiceByClientId(clientId);
    }
}
