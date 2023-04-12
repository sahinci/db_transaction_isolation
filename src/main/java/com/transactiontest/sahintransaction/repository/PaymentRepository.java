package com.transactiontest.sahintransaction.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transactiontest.sahintransaction.model.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer>
{
}
