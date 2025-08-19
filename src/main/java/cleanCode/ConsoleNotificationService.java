package cleanCode;

public class ConsoleNotificationService implements NotificationService {
    public void sendWelcomeNotification(User user) {
        System.out.println("Sending email to client: " + user.getEmail());
        System.out.println("Sending SMS to client: " + user.getPhone());
    }
}
