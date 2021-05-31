package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.*;

public class Main {

    public static void main(String[] args){

        // Supplier:
        System.out.println("Supplier: ");
        Supplier<Long> freshDate = () -> (new Date()).getTime();
        System.out.println(freshDate.get());
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println(freshDate.get());


        // Biconsumer
        System.out.println("-----------------------------------");
        System.out.println("Biconsumer: ");
        BiConsumer<ArrayList<Integer>, ArrayList<Integer>> moveFromTo = (A, B) -> {
            for (Integer x : A)
                B.add(x);
            A.clear();
        };

        ArrayList<Integer> A = new ArrayList<>(List.of(5, 6, 7, 8));
        ArrayList<Integer> B = new ArrayList<>(List.of(1, 2, 3, 4));
        moveFromTo.accept(A, B);
        System.out.println("A = " + A.toString());
        System.out.println("B = " + B.toString());

        // intFucnction
        System.out.println("-----------------------------------");
        System.out.println("IntFunction: ");
        IntFunction<ArrayList<Integer>> fib = (n) -> {
          ArrayList<Integer> list = new ArrayList<>();
          for (int i = 0;i < n;i++){
              switch (i) {
                  case 0:
                  case 1:
                      list.add(1);
                      break;
                  default:
                      list.add(list.get(i-1) + list.get(i - 2));
              }
          }

          return list;
        };

        System.out.println("fib(10) : " + fib.apply(10).toString());

        // Predicate
        System.out.println("-----------------------------------");
        System.out.println("Predicate: ");
        Predicate<Integer> isOdd = x -> (x % 2) == 1;
        System.out.println("isOdd(2): " + isOdd.test(2));
        System.out.println("isOdd(3): " + isOdd.test(3));

        // Unary Operator
        System.out.println("-----------------------------------");
        System.out.println("Unary Operator: ");
        UnaryOperator<ArrayList<Double>> half = list -> {
            ArrayList<Double> newList = new ArrayList<>();
            for (Double d : list)
                newList.add(d / 2);
            return newList;
        };

        ArrayList<Double> list = new ArrayList<Double>(List.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        System.out.println("list : " + list.toString());
        System.out.println("half list : " + half.apply(list));

    }


}
