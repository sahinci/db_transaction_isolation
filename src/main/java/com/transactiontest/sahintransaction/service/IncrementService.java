package com.transactiontest.sahintransaction.service;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.Objects;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.transactiontest.sahintransaction.model.Increment;
import com.transactiontest.sahintransaction.repository.IncrementRepository;

import jakarta.persistence.LockModeType;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@EnableRetry
public class IncrementService
{
    private final IncrementRepository incrementRepository;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Retryable(retryFor = SQLException.class, maxAttempts = 2, backoff = @Backoff(delay = 100))
    public void increase()
    {

        Increment increment = incrementRepository.getIncrementByName("test")
            .orElseGet(() -> Increment.builder().name("test").amount(0).build());
        increment.setAmount(increment.getAmount() + 1);
        incrementRepository.save(increment);
    }
}
