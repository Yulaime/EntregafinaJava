package com.ecommerce.repository;

import com.ecommerce.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    Invoice findTopByClientIdOrderByCreatedAtDesc(Long clientId);
}
