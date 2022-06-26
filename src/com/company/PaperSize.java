package com.company;

import java.math.BigDecimal;

public enum PaperSize{
    A1(BigDecimal.valueOf(0.9)),
    A2(BigDecimal.valueOf(0.7)),
    A3(BigDecimal.valueOf(0.5)),
    A4(BigDecimal.valueOf(0.3)),
    A5(BigDecimal.valueOf(0.1));

    BigDecimal cost;

    PaperSize(BigDecimal cost){
        this.cost = cost;
    }
    BigDecimal getPaperCost() {
        return cost;
    }

}
