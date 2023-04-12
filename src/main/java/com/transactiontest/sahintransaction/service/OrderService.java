package com.transactiontest.sahintransaction.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.transactiontest.sahintransaction.model.Orders;
import com.transactiontest.sahintransaction.model.Payment;
import com.transactiontest.sahintransaction.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService
{
    private final OrderRepository orderRepository;
    private final PaymentService paymentService;

//    @Transactional
    public void makeOrder(Orders order)
    {
        orderRepository.save(order);

        Payment payment = Payment.builder().orderId(null).price(BigDecimal.TEN).build();
        paymentService.pay(payment);
    }

}
