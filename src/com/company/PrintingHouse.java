package com.company;

import java.math.BigDecimal;
import java.util.ArrayList;

public class PrintingHouse {
    ArrayList<Employee> employees;
    int bonusPercentage;
    BigDecimal profitsTarget;
    BigDecimal expenses = BigDecimal.valueOf(0);
    BigDecimal profits;
    ArrayList<Print> prints;

    PrintingHouse(int bonusPercentage, BigDecimal profitsTarget, ArrayList<Employee>employees, ArrayList<Print> prints){
        this.employees = employees;
        this.bonusPercentage = bonusPercentage;
        this.profitsTarget = profitsTarget;
        this.prints = prints;
    }

    PrintingHouse(int bonusPercentage, BigDecimal profitsTarget){
        this.bonusPercentage = bonusPercentage;
        this.profitsTarget = profitsTarget;
    }

    void addPrint(Print print){
        prints.add(print);
    }
    void addEmployee(Employee employee){
        employees.add(employee);
    }
    void calculateExpenses(){
        int bonusPercentage = 0;
        if (profits.compareTo(profitsTarget) == 1){
            bonusPercentage = 5;
        }
        for(Employee employee : employees){
            if (employee.position == WorkerPosition.MANAGER){
                employee.salary.add(employee.salary.multiply(BigDecimal.valueOf(bonusPercentage)).divide(BigDecimal.valueOf(100))); // Add Bonus to Manager salary;
            }
            expenses.add(employee.salary);
        }
        for(Print print : prints){
            BigDecimal printCost = (print.paperType.cost.add(print.paperSize.cost))
                    .multiply(BigDecimal.valueOf(print.numberOfPages));
            expenses.add(printCost);
        }
    }
    void sellPrints(Print print, int amount) { //Function to simulate purchase from a potential customer
        BigDecimal bill = BigDecimal.valueOf(0);
        if (amount >= print.discountAt) {
            for (int count = 0; count < amount; count++) {
                bill.add(print.calculateDiscount(BigDecimal.valueOf(5)));
            }
        } else {
            bill.add(print.sellCost.multiply(BigDecimal.valueOf(amount)));
        }
        profits.add(bill);
    }
}

