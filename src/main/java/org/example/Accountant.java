package org.example;

import java.util.Arrays;
import java.util.List;

public class Accountant<T extends Employee> extends Employee {
    public Accountant(String name, int baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public int getSalary() {
        return getBaseSalary() * 2;
    }

    public static void main(String[] args) {
        Accountant<Worker> accWorker1 = new Accountant<>("WorkerAcc1", 100);
        Accountant<Worker> accWorker2 = new Accountant<>("WorkerAcc2", 200);
        Accountant<Manager> accMan1 = new Accountant<>("ManAcc1", 1000);
        Accountant<Manager> accMan2 = new Accountant<>("ManAcc2", 2000);

        List<Accountant<Worker>> accWorkList = Arrays.asList(accWorker1, accWorker2);
        List<Accountant<Manager>> accManList = List.of(accMan1, accMan2);

        accWorkList.add(accWorker1);

        System.out.println(getSalaryG(accManList));
    }

    public static int getSalaryG(List<? extends Accountant<?>> accountants) {
        int sum = 0;
        for (Accountant<?> accountant : accountants) {
            sum += accountant.getSalary();
        }
        return sum;
    }
}
