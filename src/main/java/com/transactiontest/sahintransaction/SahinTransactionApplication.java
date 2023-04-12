package com.transactiontest.sahintransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transactiontest.sahintransaction.service.InvoiceService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
public class SahinTransactionApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(SahinTransactionApplication.class, args);
    }


}
