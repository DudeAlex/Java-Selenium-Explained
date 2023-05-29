package org.example;

public class Journal implements Printable{
    private String name;
    public Journal(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public void print() {
        Printable.super.print();
    }

    public static void main(String[] args) {
        Printable journal = new Journal("Murzilka");
        journal.print();
    }
}
