package org.example;

public class Singleton {
    private static Singleton instance;

    private Singleton() {
        // Private constructor to prevent instantiation from outside
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void killInstance() {
        if (instance != null) {
            instance = null;
            System.out.println("Instance has been killed!");
        } else {
            System.out.println("Instance is null, nothing to kill!");
        }
    }

    public void printInstance() {
        if (instance != null) {
            System.out.println("I am Singleton and I am a single instance! " + instance.toString());
        } else {
            System.out.println("Instance is null!");
        }
    }
}
    class Main1 {
        public static void main(String[] args) {
            Singleton singleton = Singleton.getInstance();
            singleton.printInstance();
            Singleton singleton1 = Singleton.getInstance();
            singleton.printInstance();
            singleton1.printInstance();
            singleton1.killInstance();
            singleton.killInstance();
            singleton.printInstance();
            singleton = Singleton.getInstance();
            singleton.printInstance();
        }
    }












