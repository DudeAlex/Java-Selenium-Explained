package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Main {
    public static void main(String[] args) throws Exception {

        Employee employee = getSomeone("manager");
    //    Worker worker = (Worker) employee;
        System.out.println(employee.getClass().toString());
//
//        Salary wr1 = new Worker("Smith", 300);
//        Salary mn1 = new Manager("Peter", 1000, 200);
//
//        int a=1;
//        if(a<=0)
//          throw new Exception();
//
//        Salary[] salaries = {wr1, mn1};
//
//        for (Salary elem : salaries) {
//            System.out.println(elem.getSalary());
//        }
//
//        List<Salary> arr = new ArrayList<>();
//        arr.add(wr1);
//        arr.add(mn1);
//
//        for (Salary elem   : arr) {
//            System.out.println(elem.getSalary());
//        }
//
//           System.out.println(getSalary(MonthUtils.Month.getAllMonths()));
    }

    public static int getSalary(MonthUtils.Month[] months){
        int result = 0;
        for (int i = 0; i<months.length; i++){
            result += months[i].getWorkDays()*100;
        }
        return result;
    }

    public static Employee getSomeone(String title){
        if(title.toLowerCase().contains("manager")){
            return new Manager("Peter", 100, 30);

        } else if (title.toLowerCase().contains("worker")) {
            return new Worker("Paul", 50);
        } else {
            return null;
        }
    }
}
