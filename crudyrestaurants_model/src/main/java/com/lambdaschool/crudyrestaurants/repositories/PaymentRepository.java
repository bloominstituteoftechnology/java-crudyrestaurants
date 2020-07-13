package com.lambdaschool.crudyrestaurants.repositories;

import com.lambdaschool.crudyrestaurants.models.Payment;
import org.springframework.data.repository.CrudRepository;

/**
 * The CRUD Repository connecting Payment to the rest of the application.
 */
public interface PaymentRepository extends CrudRepository<Payment, Long>
{
}
