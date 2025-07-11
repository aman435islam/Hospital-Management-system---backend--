package com.hms.repository;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.model.MedicineSale;

public interface MedicineSaleRepository extends JpaRepository<MedicineSale, Long> {

    Optional<MedicineSale> findByPrescriptionId(Long prescriptionId); // ইতিমধ্যেই আছে

    boolean existsByPrescriptionId(Long prescriptionId); // ✅ ঠিক method
}
