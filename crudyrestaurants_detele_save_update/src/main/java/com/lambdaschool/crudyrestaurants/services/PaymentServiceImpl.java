package com.lambdaschool.crudyrestaurants.services;

import com.lambdaschool.crudyrestaurants.models.Payment;
import com.lambdaschool.crudyrestaurants.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

/**
 * Implements the PaymentService Interface.
 */
@Transactional
@Service(value = "paymentService")
public class PaymentServiceImpl implements PaymentService
{
    /**
     * Connects this service to the Payment Table.
     */
    @Autowired
    PaymentRepository paymentrepos;

    @Override
    public Payment findPaymentById(long id)
    {
        return paymentrepos.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Payment " + id + " Not Found"));
    }

    @Transactional
    @Override
    public Payment save(Payment payment)
    {
        // restaurants not added through payments
        if (payment.getRestaurants()
            .size() > 0)
        {
            throw new EntityExistsException("Restaurants not added through payments");
        }

        Payment newPayment = new Payment();
        newPayment.setRestaurants(new ArrayList<>());
        newPayment.setType(payment.getType());

        return paymentrepos.save(payment);
    }
}
