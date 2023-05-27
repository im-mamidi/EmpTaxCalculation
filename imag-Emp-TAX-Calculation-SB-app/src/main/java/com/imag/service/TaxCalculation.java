package com.imag.service;

import com.imag.Constant.ImagConstants;
import com.imag.domin.Employee;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class TaxCalculation {

    public Employee calculateTax(double salary, Calendar doj, Employee employee) {
        double tax = 0.0;

        int daysWorked = Calendar.getInstance().get(Calendar.DAY_OF_MONTH) - doj.get(Calendar.DAY_OF_MONTH);

        double totalSalary = salary *(daysWorked/ImagConstants.MONTH_DAYS);
        employee.setYearSalary(totalSalary*12);
        if (totalSalary <= 2500000) {
        } else if (totalSalary <= 5000000) {
            tax = totalSalary * 0.05;
        } else if (totalSalary <= 10000000) {
            tax = totalSalary * 0.1;
        } else {
            tax = totalSalary * 0.2;
        }
        employee.setTaxDeduction(tax);

        if (totalSalary > 2500000) {
            //tax += totalSalary - 2500000 * 0.02;
            employee.setCessAmount(totalSalary - 2500000 * 0.02);
        }
        return employee;
    }
}
