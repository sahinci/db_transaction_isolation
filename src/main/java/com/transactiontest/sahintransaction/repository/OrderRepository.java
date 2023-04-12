package com.transactiontest.sahintransaction.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transactiontest.sahintransaction.model.Orders;

@Repository
public interface OrderRepository extends CrudRepository<Orders, Integer>
{
}
