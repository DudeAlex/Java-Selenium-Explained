package org.example;

public class Manager extends Employee{
    private int numberOfSubordinates;

    public Manager(String name, int baseSalary, int numberOfSubordinates) {
        super(name, baseSalary);
        this.numberOfSubordinates = numberOfSubordinates;
    }

    public int getNumberOfSubordinates() {
        return numberOfSubordinates;
    }

    public void setNumberOfSubordinates(int numberOfSubordinates) {
        this.numberOfSubordinates = numberOfSubordinates;
    }

    @Override
    public int getSalary() {
        return (int)(getBaseSalary() * (1 + numberOfSubordinates * 3/100.0));
    }

    @Override
    public String toString() {
        return super.toString() + " Manager{" +
                "numberOfSubordinates=" + numberOfSubordinates +
                '}';
    }
}
