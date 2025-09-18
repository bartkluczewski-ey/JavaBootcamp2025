
package cleanCode;

public class UserValidator {
    public void validate(String name, String email, String phone, int age) {
        if (name != null && !name.trim().isEmpty() && name.length() <= 20 && name.matches("[a-zA-Z]+")) {
            if (email != null && email.contains("@")) {
                if (phone != null && !phone.trim().isEmpty()) {
                    if (age <= 18) {
                        throw new IllegalArgumentException("Invalid age, User must be older than 18.");
                    }
                } else {
                    throw new IllegalArgumentException("Invalid phone number");
                }
            } else {
                throw new IllegalArgumentException("Invalid email");
            }
        } else {
            throw new IllegalArgumentException("Invalid name. Must be 1-20 letters.");
        }
    }
}
