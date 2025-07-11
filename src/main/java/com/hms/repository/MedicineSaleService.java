package com.hms.repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmd.dto.PaymentProcessRequest;
import com.hms.model.MedicineSale;
import com.hms.model.Prescription;
import com.hms.model.SaleMedicineDetail;

@Service
public class MedicineSaleService {

    @Autowired
    private MedicineSaleRepository medicineSaleRepository;

    @Autowired
    private PrescriptionRepository prescriptionRepository;


    @Transactional
    public MedicineSale generateSaleFromPrescription(Long prescriptionId) {
        Prescription prescription = prescriptionRepository.findById(prescriptionId)
            .orElseThrow(() -> new RuntimeException("Prescription not found with id: " + prescriptionId));

        // Check if sale already exists
        if (medicineSaleRepository.findByPrescriptionId(prescriptionId).isPresent()) {
            throw new RuntimeException("Bill already generated for this prescription.");
        }

        MedicineSale sale = new MedicineSale();
        sale.setPrescriptionId(prescription.getId());
        sale.setPatientName(prescription.getPatientName());
        sale.setSaleDate(new Date());
        sale.setStatus("UNPAID");
        sale.setPaidAmount(0.0);

        List<SaleMedicineDetail> saleMedicines = prescription.getPrescriptionMedicines().stream().map(pm -> {
            SaleMedicineDetail smd = new SaleMedicineDetail();
            smd.setMedicineName(pm.getMedicineName());
            smd.setStrength(pm.getStrength());
            smd.setQuantityPrescribed(pm.getQuantityPrescribed());
            smd.setPricePerUnit(pm.getPricePerUnit());
            smd.setSubtotal(pm.getSubtotal());
            smd.setMedicineSale(sale);
            return smd;
        }).collect(Collectors.toList());



        sale.setMedicines(saleMedicines);

        // Calculate total amount
        double totalAmount = saleMedicines.stream()
            .mapToDouble(SaleMedicineDetail::getSubtotal)
            .sum();

        sale.setTotalAmount(totalAmount);
        sale.setDueAmount(totalAmount);

        return medicineSaleRepository.save(sale);
    }

    public MedicineSale getSaleByPrescriptionId(Long prescriptionId) {
        return medicineSaleRepository.findByPrescriptionId(prescriptionId)
            .orElseThrow(() -> new RuntimeException("Sale not found for prescription id: " + prescriptionId));
    }

    public MedicineSale processPayment(Long saleId, PaymentProcessRequest paymentRequest) {
        MedicineSale sale = medicineSaleRepository.findById(saleId)
            .orElseThrow(() -> new RuntimeException("Sale not found with id: " + saleId));

        if ("PAID".equalsIgnoreCase(sale.getStatus())) {
            throw new RuntimeException("This bill is already fully paid.");
        }

        double newPaidAmount = sale.getPaidAmount() + paymentRequest.getPaidAmount();
        sale.setPaidAmount(newPaidAmount);

        double due = sale.getTotalAmount() - newPaidAmount;
        sale.setDueAmount(due);

        sale.setPaymentMethod(paymentRequest.getPaymentMethod());

        if (due <= 0) {
            sale.setStatus("PAID");
        } else {
            sale.setStatus("PARTIAL");
        }

        return medicineSaleRepository.save(sale);
    }
    
}


