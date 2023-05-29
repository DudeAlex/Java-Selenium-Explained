package org.example;
public class Calculate{

    public static void main(String[] args) {

        Calculable c = new Calculation();
        System.out.println(c.sum(1, 2));
        System.out.println(c.sum(1, 2, 4));
        System.out.println(c.sum(4,5,6,7));
    }
}
class Calculation implements Calculable {

}
interface Calculable {

    default int sum(int a, int b){
        return sumAll(a, b);
    }
    default int sum(int a, int b, int c){
        return sumAll(a, b, c);
    }

    default int sum(int... args){
        return sumAll(args);
    }

    private int sumAll(int... values){
        int result = 0;
        for(int n : values){
            result += n;
        }
        return result;
    }
}