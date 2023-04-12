package com.transactiontest.sahintransaction.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transactiontest.sahintransaction.CreateInvoiceRequest;
import com.transactiontest.sahintransaction.service.InvoiceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoiceController
{
    private final InvoiceService invoiceService;
    @PostMapping
    void createIfNotExist(@RequestBody CreateInvoiceRequest request)
    {
        this.invoiceService.createIfNotExist(request);
    }
}