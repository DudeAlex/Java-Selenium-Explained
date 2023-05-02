package org.example;

public class Worker extends Employee{

    public Worker(String name, int baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public int getSalary() {
        return getBaseSalary();
    }
}
