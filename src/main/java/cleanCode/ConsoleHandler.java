package cleanCode;

import java.util.Scanner;

public class ConsoleHandler {
    private final UserService userService;

    public ConsoleHandler(UserService userService) {
        this.userService = userService;
    }

    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter user name:");
            String name = scanner.nextLine();
            System.out.println("Enter user email:");
            String email = scanner.nextLine();
            System.out.println("Enter phone number:");
            String phone = scanner.nextLine();

            int age = readUserAge(scanner);

            try {
                this.userService.registerUser(name, email, phone, age);
                System.out.println("User processed successfully");
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

    }

    private int readUserAge(Scanner scanner) {

        while(true){
            try{
                System.out.println("Enter user age:");
                String ageInput = scanner.nextLine();
                return Integer.parseInt(ageInput);
            }catch (NumberFormatException e){
                System.err.println("Invalid age format. Please enter a number.");
            }
        }

    }
}
