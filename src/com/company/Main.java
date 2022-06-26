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

        printingMachine1.printItem(book1);
        printingMachine2.printItem(book2);
        printingMachine1.start();
        printingMachine2.start();

     }
}
