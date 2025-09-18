package cleanCode;

public class Application {
    public static void main(String[] args) {
        UserRepository userRepository = new InMemoryUserRepository();
        NotificationService notificationService = new ConsoleNotificationService();
        LoggingService loggingService = new FileLoggingService("user.log");
        UserValidator userValidator = new UserValidator();
        UserService userService = new UserService(userRepository, notificationService, loggingService, userValidator);
        ConsoleHandler consoleHandler = new ConsoleHandler(userService);
        consoleHandler.start();
    }
}
