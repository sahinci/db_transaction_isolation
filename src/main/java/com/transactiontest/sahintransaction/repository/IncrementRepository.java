package com.transactiontest.sahintransaction.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transactiontest.sahintransaction.model.Increment;

import jakarta.persistence.LockModeType;

@Repository
public interface IncrementRepository extends JpaRepository<Increment, Integer>
{
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Increment> getIncrementByName(String name);
}
