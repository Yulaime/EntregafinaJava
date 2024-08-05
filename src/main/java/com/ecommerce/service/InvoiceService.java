package com.ecommerce.service;

import com.ecommerce.entity.Invoice;
import com.ecommerce.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice getLastInvoiceByClientId(Long clientId) {
        return invoiceRepository.findTopByClientIdOrderByCreatedAtDesc(clientId);
    }
}
