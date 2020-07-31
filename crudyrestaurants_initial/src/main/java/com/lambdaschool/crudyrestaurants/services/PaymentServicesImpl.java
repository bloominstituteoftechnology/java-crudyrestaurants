package com.lambdaschool.crudyrestaurants.services;

import com.lambdaschool.crudyrestaurants.models.Payment;
import com.lambdaschool.crudyrestaurants.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service(value="paymentService")
public class PaymentServicesImpl implements PaymentServices{

    @Autowired
    private PaymentRepository paymentrepos;

    @Transactional  // only when we save or modify data, part fails, whole fails
    @Override
    public Payment save(Payment payment) {
        return paymentrepos.save(payment);
    }

    @Transactional
    @Override
    public void deleteAll() {
        paymentrepos.deleteAll();
    }


}
