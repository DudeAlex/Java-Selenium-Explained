package org.example;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {
        Salary wr1 = new Worker("Smith", 300);
        Salary mn1 = new Manager("Peter", 1000, 200);

        int a=1;
        if(a<=0)
          throw new Exception();

        Salary[] salaries = {wr1, mn1};

        for (Salary elem : salaries) {
            System.out.println(elem.getSalary());
        }

        List<Salary> arr = new ArrayList<>();
        arr.add(wr1);
        arr.add(mn1);

        for (Salary elem   : arr) {
            System.out.println(elem.getSalary());
        }

        //   System.out.println(getSalary(MonthUtils.Month.getAllMonths()));
    }

    public static int getSalary(MonthUtils.Month[] months){
        int result = 0;
        for (int i = 0; i<months.length; i++){
            result += months[i].getWorkDays()*100;
        }
        return result;
    }
}
