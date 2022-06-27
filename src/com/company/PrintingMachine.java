package com.company;

public class PrintingMachine extends Thread {
    int maxPaperCapacity;
    int pagesPerMinute;
    int loadedPaper;
    PrinterType printerType;
    String printerName;
    Print print;
    int failedPrintPage = 0;

    public PrintingMachine(int maxPaperCapacity, int pagesPerMinute, int loadedPaper, PrinterType printerType, String printerName) {
        this.maxPaperCapacity = maxPaperCapacity;
        this.pagesPerMinute = pagesPerMinute;
        this.loadedPaper = loadedPaper;
        this.printerType = printerType;
        if (loadedPaper == 0){
            throw new ArithmeticException("The printer has 0 paper loaded inside. Please load up to " + maxPaperCapacity + " papers");
        }
        this.printerName = printerName;
    }
    void printItem(Print print){
        this.print = print;
    }
    @Override
    public void run() {
        try {
            int page = 0;
            if (this.failedPrintPage != 0 && this.loadedPaper != 0) {
                page = failedPrintPage;
                this.failedPrintPage = 0;
            }
            while (page < print.numberOfPages) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                page++;
                if (this.loadedPaper == 0) {
                    this.failedPrintPage = page;
                    System.out.println("Not enough paper to finish printing " + print.printTitle + ". Current " +
                            "print failed on page " + page);
                }
                this.loadedPaper--;
                System.out.println(printerName + ": printing page " + page + " of " + print.numberOfPages + " from "
                        + print.printTitle);
            }
        }
        catch (NullPointerException npe){
            System.out.println("You have to load a print that would be printed. You can perform that by using printItem()");
        }
    }

    void loadMorePaper(int amountOfPaperToLoad){
        loadedPaper+=amountOfPaperToLoad;
    }
}
