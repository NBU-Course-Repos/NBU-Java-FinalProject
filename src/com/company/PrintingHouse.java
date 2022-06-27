package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

public class PrintingHouse {
    ArrayList<Employee> employees = new ArrayList<Employee>();
    int bonusPercentage;
    BigDecimal profitsTarget;
    BigDecimal expenses;
    BigDecimal profits;
    ArrayList<Print> prints = new ArrayList<Print>();
    ArrayList<PrintingMachine> printingMachines = new ArrayList<PrintingMachine>();

    PrintingHouse(int bonusPercentage, BigDecimal profitsTarget, ArrayList<Employee> employees, ArrayList<Print> prints) {
        this.employees = employees;
        this.bonusPercentage = bonusPercentage;
        this.profitsTarget = profitsTarget;
        this.prints = prints;
        this.profits = BigDecimal.valueOf(0);
        this.expenses = BigDecimal.valueOf(0);
    }

    PrintingHouse(int bonusPercentage, BigDecimal profitsTarget) {
        this.bonusPercentage = bonusPercentage;
        this.profitsTarget = profitsTarget;
        this.profits = BigDecimal.valueOf(0);
        this.expenses = BigDecimal.valueOf(0);
    }

    void addPrint(Print print) {
        prints.add(print);
    }

    void addEmployee(Employee employee) {
        employees.add(employee);
    }

    void calculateExpenses() {
        int bonusPercentage = 0;
        if (this.profits.compareTo(this.profitsTarget) == 1) {
            bonusPercentage = 5;
        }
        for (Employee employee : employees) {
            if (employee.position == WorkerPosition.MANAGER) {
                employee.salary.add(employee.salary.multiply(BigDecimal.valueOf(bonusPercentage)).divide(BigDecimal.valueOf(100))); // Add Bonus to Manager salary;
            }
            this.expenses = expenses.add(employee.salary);
        }
        for (Print print : prints) {
            BigDecimal printCost = (print.paperType.cost.add(print.paperSize.cost))
                    .multiply(BigDecimal.valueOf(print.numberOfPages));
            System.out.println(printCost);
            this.expenses = this.expenses.add(printCost);
        }
    }

    void sellPrints(Print print, int amount) { //Function to simulate purchase from a potential customer
        BigDecimal bill = BigDecimal.valueOf(0);
        if (amount >= print.discountAt) {
            for (int count = 0; count < amount; count++) {
                bill = bill.add(print.calculateDiscount(BigDecimal.valueOf(5)));
            }
        } else {
            bill = bill.add(print.sellCost.multiply(BigDecimal.valueOf(amount)));
        }
        this.profits = this.profits.add(bill);
    }

    void addPrintingMachine(PrintingMachine printingMachine) {
        this.printingMachines.add(printingMachine);
    }

    void generateReport() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("report.txt"));
            writer.write("Printed prints: ");
            for (Print print : prints){
                writer.write(print.printTitle + ", ");
            }
            writer.write("\n Profits: " + profits);
            writer.write("\n Expenses: " + expenses);
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

