
package cleanCode;

import java.util.UUID;

public class UserService {
    private final UserRepository userRepository;
    private final NotificationService notificationService;
    private final LoggingService loggingService;
    private final UserValidator userValidator;

    public UserService(UserRepository userRepository, NotificationService notificationService, LoggingService loggingService, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
        this.loggingService = loggingService;
        this.userValidator = userValidator;
    }

    public User registerUser(String name, String email, String phone, int age) {
        userValidator.validate(name, email, phone, age);
        String userId = UUID.randomUUID().toString();
        User user = new User(userId, name, email, phone, age);
        userRepository.save(user);
        loggingService.log("User Created: " + user);
        notificationService.sendWelcomeNotification(user);

        return user;
    }
}
