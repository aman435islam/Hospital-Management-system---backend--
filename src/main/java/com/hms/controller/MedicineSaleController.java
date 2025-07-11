package com.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hmd.dto.PaymentProcessRequest;
import com.hms.model.MedicineSale;
import com.hms.repository.MedicineSaleService;

@RestController
@RequestMapping("/api/sales")
public class MedicineSaleController {

    @Autowired
    private MedicineSaleService medicineSaleService;

    @GetMapping("/prescription/{prescriptionId}")
    public ResponseEntity<MedicineSale> getSaleByPrescription(@PathVariable Long prescriptionId) {
        MedicineSale sale = medicineSaleService.getSaleByPrescriptionId(prescriptionId);
        return ResponseEntity.ok(sale);
    }
    

    @PostMapping("/from-prescription/{prescriptionId}")
    public ResponseEntity<MedicineSale> generateSale(@PathVariable Long prescriptionId) {
        MedicineSale sale = medicineSaleService.generateSaleFromPrescription(prescriptionId);
        return new ResponseEntity<>(sale, HttpStatus.CREATED);
    }

    @PostMapping("/{saleId}/process-payment")
    public ResponseEntity<MedicineSale> processPayment(@PathVariable Long saleId,
                                                      @RequestBody PaymentProcessRequest paymentRequest) {
        MedicineSale updatedSale = medicineSaleService.processPayment(saleId, paymentRequest);
        return ResponseEntity.ok(updatedSale);
    }
}

