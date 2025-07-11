package com.hms.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class IncomeReportService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Map<String, Double> getIncomeSummary(String filter) {
        String dateCondition = "";

        switch (filter) {
            case "daily":
                dateCondition = "DATE(payment_date) = CURDATE()";
                break;
            case "weekly":
                dateCondition = "payment_date BETWEEN CURDATE() - INTERVAL 7 DAY AND CURDATE()";
                break;
            case "monthly":
                dateCondition = "MONTH(payment_date) = MONTH(CURDATE())";
                break;
        }

        
        Map<String, Double> result = new HashMap<>();

        Double appointmentIncome = jdbcTemplate.queryForObject(
            "SELECT IFNULL(SUM(amount),0) FROM appointment_payment WHERE " + dateCondition, Double.class);
        Double labIncome = jdbcTemplate.queryForObject(
            "SELECT IFNULL(SUM(amount),0) FROM labtest_payment WHERE " + dateCondition, Double.class);
        Double medicineIncome = jdbcTemplate.queryForObject(
            "SELECT IFNULL(SUM(amount),0) FROM medicine_sales WHERE " + dateCondition, Double.class);

        result.put("appointment", appointmentIncome);
        result.put("labtest", labIncome);
        result.put("medicine", medicineIncome);

        return result;
    }
}
