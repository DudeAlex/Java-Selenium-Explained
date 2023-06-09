package org.example.generics;

public class Account<T>{
    private T person;
    Account(){
    }
}

class DepositAccount<P extends Person> extends Account<P>{

}
