package org.urlshortener.learn;

import java.util.Optional;

/**
 * What is Optional?
 *
 * A container that either holds a value — or holds nothing.
 * It forces you to consciously handle the "missing" case instead of getting a surprise NullPointerException.
 */
public class LearnOptional {

    public static void main(String[] args) {
        String name = findUser();
        // name could be null — you
        // might forget to check
        System.out.println(name.toUpperCase()); // 💥 NPE


        Optional<String> name2 = findUserOpt();
        // the type itself tells you
        // "this might be empty"
        name2.ifPresent(n -> System.out.println(n.toUpperCase()));


        // Has a value
        Optional<String> a = Optional.of("hello");

        // Empty — no value
        Optional<String> b = Optional.empty();

        // Value might be null — use this when you're not sure
        Optional<String> c = Optional.ofNullable(someMethodThatMightReturnNull());
    }

    private static String findUser() {
        return "John";
    }

    private static String someMethodThatMightReturnNull() {
        return null;
    }

    private static Optional<String> findUserOpt() {
        return Optional.of("John");
    }

}
