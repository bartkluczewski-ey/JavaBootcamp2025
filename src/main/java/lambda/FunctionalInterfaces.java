package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.junit.Test;


public class FunctionalInterfaces {

    BiFunction<String,Object,Object> biFunctionSyntax = (o1,o2) -> {
        String s = o1+o2;
        return s.hashCode();};
    Function<Object,Object> shortSyntax = o -> o.hashCode();
    Consumer<String> runSyntax = o -> List.of(o.toCharArray()).stream().forEach(System.out::println);
    Function<Object,Object> lambdaReferenceSyntax = Object::hashCode;
    Function<String,String> customClassReference = StreamAPI::addSuffix;

    @Test
    public void immutableExample() {

        List<String> original = Arrays.asList("Java", "Stream", "Lambda");

        // Create a new list by transforming the original
        List<String> uppercased = original.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("Original: " + original);     // [Java, Stream, Lambda]
        System.out.println("Uppercased: " + uppercased); // [JAVA, STREAM, LAMBDA]

    }

    @Test
    public void firstClassFunction() {
        // First-class function: assigned to a variable
        Function<String, Integer> lengthFunction = s -> s.length();
        System.out.println(lengthFunction.apply("Functional")); // 10
    }

    // Higher-order function: takes a function as argument
    public static void transformAndPrint (List < String > list, Function < String, String > transformer){
        list.stream().map(transformer).forEach(System.out::println);
    }
    @Test
    public void higherOrderFunction() {
        transformAndPrint(Arrays.asList("java", "bootcamp"),returnFunction());
    }

    public Function returnFunction() {
        Function<String,String> a =  str -> str.toLowerCase().substring(1,6);
        return a;
    }




    Runnable example1 = () -> System.out.println("Hello!"); // NO input no output

    Consumer<String> example2 = someString -> System.out.println("Example2: " + someString); // One input no output

    Supplier<String> example3 = () -> "Result"; //No input one output

    Function<String, Integer> example4 = String::hashCode; //One input one output

    BiFunction<String, Integer, Boolean> example5 = (someString, someInt) -> {
        boolean b = someString.length() <= someInt;
        return b;
    };// Many inputs one output


    public String giveMeAString(Object someObject, Function<Object, String> function) {
        return function.apply(someObject);
    }


    public Runnable runnableMethod() {
        return example1;
    }

    void printString(Object obj) {
        String valueToPrint = giveMeAString(obj, strobj -> strobj.toString() + "_SomeSuffix");
        System.out.println(valueToPrint);
    }


    @Test
    public void test() {
        printString("test");
    }

    @Test
    public void grouping() {

        List<String> items = Arrays.asList("apple", "banana", "pear", "kiwi", "applepie", "orange", "peach", "Avocado");
        Map<String, List<String>> grouped = items.stream()
                .collect(Collectors.groupingBy(item -> item.substring(0,1).toLowerCase()));
        System.out.println(grouped);

    }

}
