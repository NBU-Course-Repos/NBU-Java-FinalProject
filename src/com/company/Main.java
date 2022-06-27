package com.company;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        PrintingHouse Ciela = new PrintingHouse(5, BigDecimal.valueOf(200));
        Print book1 = new Print(PrintType.BOOK,PaperSize.A4, PaperType.REGULAR, "Peter Pan", 100,
                BigDecimal.valueOf(100), 50);
        Print book2 = new Print(PrintType.BOOK,PaperSize.A4, PaperType.REGULAR, "WinnieThePooh", 20,
                BigDecimal.valueOf(100), 50);
        PrintingMachine printingMachine1 = new PrintingMachine(10000, 10, 100,
                PrinterType.BW, "Gosho");
        PrintingMachine printingMachine2 = new PrintingMachine(19, 10, 100,
                PrinterType.BW, "Tosho");

        Employee machineWorker1 = new Employee(WorkerPosition.PRINTING_OPERATOR);
        Employee manager1 = new Employee(WorkerPosition.MANAGER);
        Employee.salary = BigDecimal.valueOf(1200);
        System.out.println(machineWorker1.salary);

        Ciela.addEmployee(machineWorker1);
        Ciela.addEmployee(manager1);
        Ciela.sellPrints(book1, 100);
        Ciela.calculateExpenses();
        System.out.println(Ciela.expenses);
        System.out.println(Ciela.profits);
        Ciela.addPrint(book1);
        Ciela.addPrint(book2);
        printingMachine1.printItem(book1);
        printingMachine2.printItem(book2);
        Ciela.addPrintingMachine(printingMachine1);
        Ciela.addPrintingMachine(printingMachine2);
        for (PrintingMachine printer : Ciela.printingMachines){
            printer.start();
        }

        Ciela.generateReport();

     }
}
