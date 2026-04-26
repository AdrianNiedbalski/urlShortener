package org.urlshortener.learn;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * What is a Functional Interface?
 * An interface with exactly one abstract method. That's the whole definition.
 * The @FunctionalInterface annotation is optional but recommended — it makes the compiler enforce the rule.
 */
public class LearnFunctionalInterfaces {
    public static void main(String[] args) {


        // Function — transform a value
        Function<String, Integer> length = s -> s.length();
        length.apply("hello"); // → 5


        // Predicate — check a condition
        Predicate<String> isLong = s -> s.length() > 5;
        isLong.test("hi");    // → false
        isLong.test("morning"); // → true


        // Consumer — do something, return nothing
        Consumer<String> print = s -> System.out.println(s);
        print.accept("hello"); // → prints "hello"


        // Supplier — produce a value, take nothing
        Supplier<String> greeting = () -> "Good morning!";
        greeting.get(); // → "Good morning!"






        Transformer<String> upper = s -> s.toUpperCase();
        Transformer<String> trim  = s -> s.trim();

        upper.transform("hello");    // "HELLO"
        trim.transform("  hi  ");  // "hi"
    }
}


@FunctionalInterface
interface MathOp {
    int apply(int a, int b); // ← the one abstract method
}

@FunctionalInterface
interface Transformer<T> {
    T transform(T input);
}