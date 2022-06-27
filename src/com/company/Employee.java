package com.company;

import java.math.BigDecimal;

public class Employee {
    WorkerPosition position;
    static BigDecimal salary;

    Employee(WorkerPosition position){
        this.position = position;
    }

}
