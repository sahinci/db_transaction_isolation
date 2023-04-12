package com.transactiontest.sahintransaction.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.transactiontest.sahintransaction.model.Payment;
import com.transactiontest.sahintransaction.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService
{
    private final PaymentRepository paymentRepository;
    @Transactional(propagation = Propagation.MANDATORY)
    public void pay(Payment payment)
    {
//        throw new RuntimeException();
        paymentRepository.save(payment);

    }
}
