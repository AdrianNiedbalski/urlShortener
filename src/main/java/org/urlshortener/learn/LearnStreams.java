package org.urlshortener.learn;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * What is a Stream?
 * A pipeline for processing sequences of elements. You describe what you want done — the stream figures out how. No index tracking, no temp lists, no manual loops.
 * Three parts, always in this order:
 * source -> intermediate ops -> terminal ops
 */
public class LearnStreams {

    public static void main(String[] args) {
        List.of(1, 2, 3, 4, 5, 6)   // source
                .stream()
                .filter(n -> n % 2 == 0)  // intermediate — keep evens
                .map(n -> n * 10)          // intermediate — multiply
                .collect(Collectors.toList()); // terminal → [20, 40, 60]


        // From a collection
        List.of("a","b","c").stream();

        // From values directly
        Stream.of(1, 2, 3);

        // From an array
        Arrays.stream(new int[]{1, 2, 3});

        // Infinite stream (use limit!)
        Stream.iterate(0, n -> n + 1).limit(10); // 0,1,2...9
        Stream.generate(Math::random).limit(5);

        // From a string's characters
        "hello".chars(); // IntStream of char codes
        
        //---------------------------------------------

        List<PcUser> PcUsers = List.of(
                new PcUser("Alice", 32, "Warsaw"),
                new PcUser("Bob", 17, "Gdansk"),
                new PcUser("Carol", 25, "Warsaw"),
                new PcUser("Dan", 15, "Warsaw")
        );

        // Names of adults from Warsaw, sorted, joined
        String result = PcUsers.stream()
                .filter(u -> u.city().equals("Warsaw"))
                .filter(u -> u.age() >= 18)
                .map(PcUser::name)
                .sorted()
                .collect(Collectors.joining(", "));
        // → "Alice, Carol"

        // Group all PcUsers by city
        Map<String, List<PcUser>> byCity = PcUsers.stream()
                .collect(Collectors.groupingBy(PcUser::city));
        // → {Warsaw=[Alice,Carol,Dan], Gdansk=[Bob]}

        // Average age of adults
        OptionalDouble avgAge = PcUsers.stream()
                .filter(u -> u.age() >= 18)
                .mapToInt(PcUser::age)
                .average();
        // → 28.5
    }
}

record PcUser(String name, int age, String city) {}