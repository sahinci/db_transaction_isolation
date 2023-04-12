package com.transactiontest.sahintransaction.controllers;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transactiontest.sahintransaction.model.Orders;
import com.transactiontest.sahintransaction.model.Payment;
import com.transactiontest.sahintransaction.service.IncrementService;
import com.transactiontest.sahintransaction.service.OrderService;
import com.transactiontest.sahintransaction.service.PaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/finance")
@RequiredArgsConstructor
public class FinanceController
{
    private final PaymentService paymentService;
    private final OrderService orderService;
    private final IncrementService incrementService;
    private Object lockObject = new Object();

    @PostMapping("/makeOrder")
    void makeOrder()
    {
        Orders order = Orders.builder().unitAmount(1).unitPrice(BigDecimal.TEN).build();
        orderService.makeOrder(order);
    }

    @PostMapping("/pay")
    void pay(@RequestBody Payment paymentRequest)
    {
        Payment payment = Payment.builder().orderId(1L).price(BigDecimal.TEN).build();
        paymentService.pay(payment);
    }

    @PostMapping("/inc")
    void inc()
    {
//        synchronized (lockObject)
//        {
            incrementService.increase();
//        }
    }
}
