package org.example;

public class ExceptionHandling {
    public static void main(String[] args)  {
        System.out.println("Before problem");
        try {
            System.out.println("Inside try block before the problem");
            Thread.sleep(1000/0);
            System.out.println("Inside try block after the problem.");
        }
        catch (InterruptedException e) {
            System.out.println("InterruptedException catch block");
        }
        catch (ArithmeticException e) {
            System.out.println("Inside the catch block.  Do not divide by zero, dude!");
            System.out.println(e.getMessage());
            throw new RuntimeException("We just threw RuntimeException");
        } finally {
            System.out.println("inside finally block");
        }

        System.out.println("After problem");
    }
}
