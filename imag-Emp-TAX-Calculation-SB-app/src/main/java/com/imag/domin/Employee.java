package com.imag.domin;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"employeeID","firstName","lastName","email","phoneNumber"})
public class Employee {

    @JsonProperty("employeeID")
    private String employeeID;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("email")
    @Email
    private String email;
    @JsonProperty("phoneNumber")
    @Size(min = 10, max = 10)
    private List<String> phoneNumber; //May have multiple phone numbers
    @JsonProperty("DOJ")
    private Calendar DOJ;
    @JsonProperty("salary")
    private double salary; //per month
    @JsonProperty("taxDeduction")
    private  double taxDeduction ;
    @JsonProperty("yearSalary")
    private double yearSalary;
    @JsonProperty("cessAmount")
    private double cessAmount;

    public double getYearSalary() {
        return yearSalary;
    }

    public void setYearSalary(double yearSalary) {
        this.yearSalary = yearSalary;
    }

    public double getCessAmount() {
        return cessAmount;
    }

    public void setCessAmount(double cessAmount) {
        this.cessAmount = cessAmount;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getTaxDeduction() {
        return taxDeduction;
    }

    public void setTaxDeduction(double taxDeduction) {
        this.taxDeduction = taxDeduction;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Calendar getDOJ() {
        return DOJ;
    }

    public void setDOJ(Calendar DOJ) {
        this.DOJ = DOJ;
    }
}
