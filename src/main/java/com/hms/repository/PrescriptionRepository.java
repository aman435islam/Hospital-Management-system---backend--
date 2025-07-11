package com.hms.repository;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hms.model.Prescription;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    
    @Query("SELECT p FROM Prescription p LEFT JOIN FETCH p.prescriptionMedicines WHERE p.id = :id")
    Optional<Prescription> findWithMedicinesById(@Param("id") Long id);
}
