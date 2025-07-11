package com.hms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hms.repository.IncomeReportService;

@RestController
@RequestMapping("/api/reports")
public class IncomeReportController {

    @Autowired
    private IncomeReportService reportService;

    @GetMapping("/income-summary")
    public Map<String, Double> getIncomeSummary(@RequestParam String filter) {
        return reportService.getIncomeSummary(filter);
    }
}
