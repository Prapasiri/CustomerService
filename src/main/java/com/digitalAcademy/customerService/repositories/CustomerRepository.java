package com.digitalAcademy.customerService.repositories;

import com.digitalAcademy.customerService.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findAllById(Long id);

}
