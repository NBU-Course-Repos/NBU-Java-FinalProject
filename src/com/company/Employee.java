package com.company;

import java.math.BigDecimal;

public class Employee {
    WorkerPosition position;
    BigDecimal salary;

    Employee(WorkerPosition position, BigDecimal salary){
        this.position = position;
        this.salary = salary;
    }
}
