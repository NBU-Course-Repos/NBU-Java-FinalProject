package com.company;

import java.awt.print.Paper;
import java.math.BigDecimal;

public enum PaperType {
    REGULAR(BigDecimal.valueOf(0.2)),
    GLOSSY(BigDecimal.valueOf(0.5)),
    NEWSPAPER(BigDecimal.valueOf(0.1));
    BigDecimal cost;

    PaperType(BigDecimal cost){
        this.cost = cost;
    }
    BigDecimal getPaperCost() {
        return cost;
    }
}
