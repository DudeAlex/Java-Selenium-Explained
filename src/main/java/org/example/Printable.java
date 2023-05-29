package org.example;
interface Printable {

    default void print(){

        System.out.println("Interface default printable method");
    }
}