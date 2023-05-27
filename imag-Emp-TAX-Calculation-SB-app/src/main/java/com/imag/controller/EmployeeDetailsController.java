package com.imag.controller;

import com.imag.Constant.ImagConstants;
import com.imag.Exception.BadRequestException;
import com.imag.domin.Employee;
import com.imag.service.TaxCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ImagConstants.IMAG)
class EmployeeDetailsController {

    @Autowired
    TaxCalculation taxCalculation;

    @RequestMapping(value = ImagConstants.UPDATE_EMPLOYEE_API, method = RequestMethod.POST, produces = ImagConstants.CONTENT_TYPE)
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){

        if (employee.getEmployeeID() == null || employee.getEmployeeID().isEmpty()) {
            throw new BadRequestException("Employee ID is required");
        }

        if (employee.getEmail() == null || employee.getEmail().isEmpty()) {
            throw new BadRequestException("Email is required");
        }

        if (employee.getPhoneNumber() == null || employee.getPhoneNumber().isEmpty()) {
            throw new BadRequestException("Phone numbers are required");
        }

       // Save the employee data
        employeeRepository.save(employee);

        return ResponseEntity.ok(employee);
    }

    @RequestMapping(value = ImagConstants.UPDATE_EMPLOYEE_TAX_API, method = RequestMethod.POST, produces = ImagConstants.CONTENT_TYPE)
    public Employee updateEmployeeTax(@PathVariable("empId") String empId){

        //read the data from DB
        Employee employee1 = retriveEmpDataFromDB(empId);

        if(employee1 != null)
            employee1 = taxCalculation.calculateTax(employee1.getSalary(), employee1.getDOJ(), employee1);

        return employee1;
    }

}
