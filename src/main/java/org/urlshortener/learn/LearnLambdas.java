package org.urlshortener.learn;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

/**
 * What is a lambda?
 * A lambda is a short anonymous function — no class, no name, just parameters and a body. It always implements a functional interface (exactly one abstract method).
 * Syntax: (parameters) -> body
 */
public class LearnLambdas {

    public static void main(String[] args) {
        // Before — anonymous class
        Runnable r = new Runnable() {
            public void run() {
                System.out.println("hello");
            }
        };

        // After — lambda
        Runnable rl = () -> System.out.println("hello");
        //----------------------------------------------


        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.add(1);
        numbers.forEach((n) -> { System.out.println(n); });

        Consumer<Integer> method = (n) -> { System.out.println(n); };
        numbers.forEach(method);



    }

    public static void printFormatted(String str, StringFunction format) {
        String result = format.run(str);
        System.out.println(result);
      }
}


interface StringFunction {
  String run(String str);
}