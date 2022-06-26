package com.company;

import java.math.BigDecimal;

public class Print {
    PrintType printType;
    PaperSize paperSize;
    PaperType paperType;
    String printTitle;
    int numberOfPages;
    BigDecimal sellCost;
    int discountAt;

    Print(PrintType printType, PaperSize paperSize, PaperType paperType, String printTitle, int numberOfPages, BigDecimal sellCost, int discountAt){
        this.printType = printType;
        this.paperSize = paperSize;
        this.paperType = paperType;
        this.printTitle = printTitle;
        this.numberOfPages = numberOfPages;
        this.sellCost = sellCost;
        this.discountAt = discountAt;
    }
    BigDecimal calculateDiscount(BigDecimal percent){
        return sellCost.multiply(percent).divide(BigDecimal.valueOf(100));
    }
}
