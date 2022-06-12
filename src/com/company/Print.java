package com.company;

import java.math.BigDecimal;

public class Print {
    PrintType printType;
    PaperSize printSize;
    PaperType paperType;
    BigDecimal paperCost;
    String printTitle;
    int numberOfPages;

    Print(PrintType printType, PaperSize printSize, PaperType paperType, String printTitle, int numberOfPages){
        this.printType = printType;
        this.printSize = printSize;
        this.paperType = paperType;
        this.printTitle = printTitle;
        this.numberOfPages = numberOfPages;
    }

    Print(){
    }

    void SetPaperCost(BigDecimal paperCost){
        this.paperCost = paperCost;
    }


}
