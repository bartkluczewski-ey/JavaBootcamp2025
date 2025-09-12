/*
package lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI {

    public static String addSuffix(String s) {
        return s + "_Suffix";

    }

    @Test
    public void imperativeDataProcessing() {

        List<String> names = Arrays.asList("Anna", "Bob", "Charlie");

// Imperative style
        List<String> result = new ArrayList<>();
        for (String name : names) {
            if (name.startsWith("A")) {
                result.add(name.toUpperCase());
            }
        }

        System.out.println(result); // [ANNA]

    }

    @Test
    public void declarativeDataProcessing() {

        List<String> names = Arrays.asList("Anna", "Bob", "Charlie");

// Declarative style using Stream API
        List<String> streamResult = names.stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(streamResult); // [ANNA]

    }

    @Test
    public void pipelineOperations() {

        List<String> words = Arrays.asList("java", "stream", "lambda");

        List<String> processed = words.stream()
                .filter(w -> w.length() > 5)       // intermediate
                .map(String::toUpperCase)          // intermediate
                .sorted()                          // intermediate
                .collect(Collectors.toList());     // terminal

        System.out.println(processed); // [LAMBDA, STREAM]

    }

    @Test
    public void lazyEvaluation() {

        Stream<String> stream = Stream.of("one", "two", "three")
                .filter(s -> {
                    System.out.println("Filtering: " + s);
                    return s.length() > 3;
                });

        // No output yet — lazy evaluation
        System.out.println("Before terminal operation");

        // Trigger evaluation
        List<String> result = stream.collect(Collectors.toList());
        System.out.println("After terminal operation");
    }

    @Test
    public void parallelism() {
        List<Integer> numbers = IntStream.rangeClosed(1, 1000)
                .boxed()
                .collect(Collectors.toList());

        long parallelStart = System.currentTimeMillis();

        int parallelSum = numbers
                .parallelStream()
                .mapToInt(n -> {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                    }
                    return n;
                })
                .sum();

        long parallelEnd = System.currentTimeMillis();
        System.out.println("Sum: " + parallelSum);
        System.out.println("Time taken: " + (parallelEnd - parallelStart) + " ms");
        long nonParallelStart = System.currentTimeMillis();

        int nonParallelSum = numbers
                .stream()
                .mapToInt(n -> {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                    }
                    return n;
                })
                .sum();

        long nonParallelEnd = System.currentTimeMillis();
        System.out.println("Sum: " + nonParallelSum);
        System.out.println("Time taken: " + (nonParallelEnd - nonParallelStart) + " ms");

    }

    @Test
    public void noStorage() {

        Stream<Double> randomNumbers = Stream.generate(Math::random).limit(5);

        randomNumbers.forEach(System.out::println);
        System.out.println("----");
//        randomNumbers.forEach(System.out::println);
      */
/** Stream.generate() creates a stream of random numbers on demand.
        The stream doesn't store these numbers — each one is generated when needed.
        Once consumed (e.g., by forEach), the stream is gone and cannot be reused.*//*

    }

    @Test
    public void functionalInterfaces() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        Predicate<String> startsWithA = name -> name.startsWith("A");
        Function<String, String> toUpper = String::toUpperCase;
        Consumer<String> printer = System.out::println;

        names.stream()
                .filter(startsWithA)
                .map(toUpper)
                .forEach(printer); // Prints ALICE

    }


    @Test
    public void nonInterface() {

        List<String> items = new ArrayList<>(Arrays.asList("apple", "banana", "cherry"));

        items.stream()
                .peek(item -> {
                    // Avoid modifying the list here!
                    items.add("new"); // ❌ This would cause ConcurrentModificationException
                })
                .forEach(System.out::println);
    }
}
*/
