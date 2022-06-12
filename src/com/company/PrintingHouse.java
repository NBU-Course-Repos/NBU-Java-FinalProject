package com.company;

import java.math.BigDecimal;

public class PrintingHouse {
    Employee[] employees;
    int bonusPercentage;
    BigDecimal profitsTarget;
    BigDecimal expenses = BigDecimal.valueOf(0);
    BigDecimal profits;
    Print[] prints;

    PrintingHouse(int bonusPercentage, BigDecimal profitsTarget, Employee[]employees, Print[] prints){
        this.employees = employees;
        this.bonusPercentage = bonusPercentage;
        this.profitsTarget = profitsTarget;
        this.prints = prints;
    }

    void calculateExpenses(){
        for(Employee employee : employees){
            expenses.add(employee.salary);

        }
    }



}

