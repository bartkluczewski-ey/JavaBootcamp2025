package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Task {
    public static void main(String[] args) {
        System.out.println("\n\nTask 1:");
        ex1();

        System.out.println("\n\nTask 2:");
        ex2();

        System.out.println("\n\nTask 3:");
        ex3();

        System.out.println("\n\nTask 4:");
        ex4();
    }

    public static void ex1(){
        Predicate<Integer>  isPrime = n -> {
            if(n<=1) return false;
            for (int i = 2; i < Math.sqrt(n); i++) {
                if(n%i==0) return false;
            }
            return true;
        };

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,13,17,19,23,24,25,31,32);

        System.out.println("Original list: "+numbers);
        System.out.println("Prime numbers: ");
        for (Integer i : numbers){
            if(isPrime.test(i)){
                System.out.print(i+" ");
            }
        }
        System.out.print(" ");


    }

    public static void ex2(){

        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee("Jan", "Kowalski"),
                new Employee("Maks", "Kolanko"),
                new Employee("Anna", "Kamień"),
                new Employee("Paweł", "Brzęczyszczykiewicz")
        ));

        System.out.println("Unsorted list: "+employees);

        Collections.sort(employees, (e1, e2) -> e1.getLastName().compareTo(e2.getLastName()));

        System.out.println("Sorted list by last name: "+employees);



    }

    public static void ex3(){
        List<String> names = Arrays.asList("Paweł", "John", "Max", "Peter", "Anna", "Jakub", "Zoe", "Katarina");

        System.out.println("Original list: "+names);

        List<String> result = names.stream()
                .filter(name -> name.startsWith("J"))
                .map(String::toUpperCase)
                .toList();

        System.out.println("Result list: "+result);
    }

    public static void ex4(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        System.out.println("Original list: "+numbers);
        int sumOfEvens = numbers.stream()
                .filter(n -> n%2==0)
                .reduce(0, Integer::sum);

        System.out.println("Sum of even numbers: "+sumOfEvens);
    }



    static class Employee{
        private String  firstName;
        private String lastName;

        public Employee(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }




}
