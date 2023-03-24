package com.transactiontest.sahintransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
public class SahinTransactionApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(SahinTransactionApplication.class, args);
    }
    @RestController
    @RequestMapping("/invoices")
    @RequiredArgsConstructor
    class InvoiceController
    {
        private final InvoiceService invoiceService;
        @PostMapping
        void createIfNotExist(@RequestBody CreateInvoiceRequest request)
        {
            this.invoiceService.createIfNotExist(request);
        }
    }

}
