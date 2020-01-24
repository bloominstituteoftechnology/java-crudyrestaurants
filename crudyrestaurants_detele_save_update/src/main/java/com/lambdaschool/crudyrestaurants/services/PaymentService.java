package com.lambdaschool.crudyrestaurants.services;

import com.lambdaschool.crudyrestaurants.models.Payment;

/**
 * The Service that works with the Menu Model.
 */
public interface PaymentService
{
    /**
     * Returns the Payment with the given primary key.
     *
     * @param id The primary key (long) of the payment you seek.
     * @return The given payment or throws an exception if not found.
     */
    Payment findPaymentById(long id);

    /**
     * Given a complete payment object, saved that payment object in the database.
     * If a primary key is provided, the record is completely replaced
     * If no primary key is provided, one is automatically generated and the record is added to the database.
     * <p>
     * Note that restaurants are not added to payments through this process
     *
     * @param payment the payment object to be saved
     * @return the saved payment object including any automatically generated fields
     */
    Payment save(Payment payment);
}
