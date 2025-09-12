package lambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Main {

    {
        // A Runnable lambda expression with no parameters
        Runnable runnable = () -> System.out.println("Hello, World!");
        runnable.run(); // Output: Hello, World!

        // A Consumer lambda expression with one parameter
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("One parameter lambda"); // Output: One parameter lambda

        // A BiFunction lambda expression with two parameters
        BiFunction<Integer, Integer, Integer> adder = (a, b) -> a + b;
        int sum = adder.apply(10, 20); // Output: 30
        System.out.println("Sum of 10 and 20 is: " + sum);
    }
}
