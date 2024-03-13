package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.InvoiceDao;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@SpringBootTest
class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    @Transactional
    void testInvoiceDaoSave() {
        // Given
        Product product1 = new Product("Product1");
        Product product2 = new Product("Product2");

        Invoice invoice = new Invoice("INV/2024/001");
        Item item1 = new Item(product1, new BigDecimal("10"), 2, invoice);
        Item item2 = new Item(product2, new BigDecimal("20"), 3, invoice);


        invoice.getItems().add(item1);
        invoice.getItems().add(item2);

        // When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();

        // Then
        Assertions.assertNotEquals(0, invoiceId);

        // Clean-up
        invoiceDao.deleteById(invoiceId);
    }
}