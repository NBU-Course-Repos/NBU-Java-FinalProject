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

    public void run(){
            int page = 0;
            if (failedPrintPage != 0 && loadedPaper != 0) {
                page = failedPrintPage;
                failedPrintPage = 0;
            }
            while (page < print.numberOfPages) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                page++;
                if (loadedPaper == 0) {
                    failedPrintPage = page;
                    System.out.println("Not enough paper to finish printing " + print.printTitle + ". Current " +
                            "print failed on page " + page);
                }
                loadedPaper--;
                System.out.println(printerName + ": printing page " + page + " of " + print.numberOfPages + " from "
                        + print.printTitle);
            }
        }

    void loadMorePaper(int amountOfPaperToLoad){
        loadedPaper+=amountOfPaperToLoad;
    }
}
