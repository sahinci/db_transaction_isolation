package com.transactiontest.sahintransaction.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.transactiontest.sahintransaction.CreateInvoiceRequest;
import com.transactiontest.sahintransaction.model.Invoice;
import com.transactiontest.sahintransaction.repository.InvoiceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InvoiceService
{
    private final InvoiceRepository invoiceRepository;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void createIfNotExist(CreateInvoiceRequest request)
    {
        Invoice invoice = this.invoiceRepository.findByUuid(request.getUuid())
            .orElseGet(() -> Invoice.builder().amount(request.getAmount()).uuid(request.getUuid()).build());
        this.invoiceRepository.save(invoice);
    }
}