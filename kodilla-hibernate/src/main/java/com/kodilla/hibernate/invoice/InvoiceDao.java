package com.kodilla.hibernate.invoice;

import org.springframework.data.repository.CrudRepository;

public interface InvoiceDao extends CrudRepository<Invoice,Integer> {
}
