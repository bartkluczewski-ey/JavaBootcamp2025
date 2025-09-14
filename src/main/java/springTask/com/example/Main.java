package springTask.com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        System.out.println("SUCCESS SCENARIO");
        userService.createUsersManually(false);

        System.out.println("FAILURE SCENARIO");
        userService.createUsersManually(true);

        context.close();
    }
}
