package com.lambdaschool.crudyrestaurants.services;

import com.lambdaschool.crudyrestaurants.models.Payment;

public interface PaymentService
{
    Payment findPaymentById(long id);

    Payment save(Payment payment);
}
