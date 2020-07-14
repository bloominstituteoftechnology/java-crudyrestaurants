package com.lambdaschool.crudyrestaurants.services;

import com.lambdaschool.crudyrestaurants.models.Payment;
import com.lambdaschool.crudyrestaurants.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implements the PaymentService Interface.
 */
@Transactional
@Service(value = "paymentService")
public class PaymentServicesImpl
        implements PaymentServices
{
    /**
     * Connects this service to the Payment Table.
     */
    @Autowired
    PaymentRepository paymentrepos;

    @Override
    public Payment save(Payment payment)
    {
        return paymentrepos.save(payment);
    }

    @Override
    public void deleteAllPayments()
    {
        paymentrepos.deleteAll();
    }
}
